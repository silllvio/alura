package financas.Testa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import financas.Modelo.Conta;

public class TestaJPA2 {

	
	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("financasBD01");
		EntityManager entityManager =  entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Conta conta =  entityManager.find(Conta.class, 1);
		
		System.out.println(conta.getTitular());
		
		entityManager.getTransaction().commit();
		
		
		
	}
	

}
