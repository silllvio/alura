package financas.Testa;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import financas.Modelo.Conta;
import financas.Modelo.Movimentacao;
import financas.Modelo.TipoMovimentacao;
import financas.Util.JPAUtil;

public class TestaRelacionamento {

	public static void main(String[] args) {

		// Criando uma conta e uma movimentação.
		// OBS: Lembrar que o estado inicial é transit
		// tanto para a conta quanto para a movimentação, assim temos que
		// persistir os dois objetos no banco

		Conta conta1 = new Conta();
		conta1.setTitular("Ana Julia");
		conta1.setBanco("Bradesco");
		conta1.setAgencia("66666");
		conta1.setAgencia("1234");

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(Calendar.getInstance()); // Pega a data do System.
		movimentacao.setDescricao("Conta de luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("199.5"));
		movimentacao.setConta(conta1);

		EntityManager entityManager1 = new JPAUtil().getEntityManager();
		entityManager1.getTransaction().begin();
		entityManager1.persist(movimentacao);
		entityManager1.persist(conta1);
		entityManager1.getTransaction().commit();
		entityManager1.close();
		
		
//		Criando uma movimentação para uma conta já existente.
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance());
		movimentacao2.setDescricao("Telefone");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal("400.77"));
		
		
		EntityManager entityManager2 = new JPAUtil().getEntityManager();
		Conta conta2 = entityManager2.find(Conta.class, 1);
		movimentacao2.setConta(conta2);
		entityManager2.getTransaction().begin();
		entityManager2.persist(movimentacao2);
		entityManager2.getTransaction().commit();
		entityManager2.close();
		
		
		

	}

}
