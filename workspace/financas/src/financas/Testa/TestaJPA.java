package financas.Testa;

import javax.persistence.EntityManager;

import financas.Modelo.Conta;
import financas.Util.JPAUtil;

public class TestaJPA {

	public static void main(String[] args) {
//		double inicio = System.currentTimeMillis();

		
//		Criando uma nova conta no banco de dados. Estado: Transient
//		OBS: Esse estado ocorre quando uma conta nunca foi inserida no banco.
		
		Conta conta1 = new Conta();
//		O ID é gerado automaticamente pela classe por conta do @GeneretedValue(strategy = GenerationType.IDENTITY)
//		Atenção ele vai inserir várias vezes com um novo ID se rodar o código, não consulta se já existe esse número de conta
		conta1.setTitular("Maria");
		conta1.setBanco  ("Caixa");
		conta1.setNumero ("123345");
		conta1.setAgencia("321");

		EntityManager entityManager1 = new JPAUtil().getEntityManager();

		entityManager1.getTransaction().begin();
		entityManager1.persist(conta1);
		entityManager1.getTransaction().commit();
		entityManager1.close();
		
//		Essa conta já existe no banco de dados, nesse caso temos que fazer um merge. Estado: Detached.
//		Após rodar o código pela segunda vez, o estado passará a ser managed.
//		OBS: só funciona com a abertura e fechamento da transação.
		
		Conta conta2 = new Conta();
		conta2.setId(3);
		conta2.setTitular("Maria");
		conta2.setBanco("Caixa");
		conta2.setNumero("123345");
		conta2.setAgencia("321");
		
		EntityManager entityManager2 = new JPAUtil().getEntityManager();
		
		entityManager2.getTransaction().begin();
		entityManager2.merge(conta2);
		entityManager2.getTransaction().commit();
		entityManager2.close();
		
//		Buscando um objeto no banco de dados. Estado: Managed
		
		EntityManager entityManager3 = new JPAUtil().getEntityManager();
		
		Conta conta3 = entityManager3.find(Conta.class, 10);
		System.out.println(conta3.getTitular());
		entityManager3.close();
		
		
//		Buscando e atualizando uma conta no banco de dados. Estado: Managed
//		OBS: lembra de abrir a transação e comitar para que a atualização realmente ocorra.
		
		EntityManager entityManager4 = new JPAUtil().getEntityManager();
		
		Conta conta4 = entityManager4.find(Conta.class, 5);
		System.out.print("Conta : " + conta4.getId());
		entityManager4.getTransaction().begin();
		conta4.setTitular("Ana Maria Braga");
		entityManager4.getTransaction().commit();
		entityManager4.close();
		
		
//		Excluindo um objeto do banco de dados. Estado: Managed
//		Só é possível excluir contas Managed, Detech por padrão nem existe no banco para que possamos exluí-la.
//		OBS: Só será removido se o EntityManager estiver com a abertura do método Transaction e begin;
//		Após removido o objeto fica na memória por um  tempo com o Estado: Removed
		
		EntityManager entityManager5 = new JPAUtil().getEntityManager();
		
		Conta conta5 = entityManager5.find(Conta.class, 2);
		System.out.println(conta5.getTitular());
		entityManager5.getTransaction().begin();
		entityManager5.remove(conta5);
		entityManager5.getTransaction().commit();
		entityManager5.close();
		
				
	}
}
