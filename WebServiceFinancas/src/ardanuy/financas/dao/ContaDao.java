package ardanuy.financas.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import ardanuy.financas.modelo.Conta;

public class ContaDao {

	private EntityManager entityManager; 
	
	public ContaDao(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	public Conta buscaContaPorId(Integer contaId){
		Query query = entityManager.createQuery("select c from Conta c where c.id=:pContaId");
		
		query.setParameter("pContaId", contaId);
		
		return (Conta) query.getSingleResult();
	}
	
}
