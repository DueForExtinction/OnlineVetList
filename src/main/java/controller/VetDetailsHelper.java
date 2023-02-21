/**
 * 
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import webVetList.VetDetails;

/**
 * @author Brandon Thompson - Brandon Thompson
 *CIS175 - Spring 2023
 * Feb 19, 2023
 */
public class VetDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("webVetList");
	
	public void insertNewVetDetails(VetDetails v) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<VetDetails> getVetList(){
		EntityManager em = emfactory.createEntityManager();
		List<VetDetails> allDetails = em.createQuery("SELECT d FROM VetDetails d").getResultList();
		return allDetails;
	}

	/**
	 * @param tempId
	 * @return
	 */
	public VetDetails searchForVetListById(Integer tempId) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		VetDetails found = em.find(VetDetails.class, tempId);
		em.close();
		return found;
	}

	/**
	 * @param vetToDelete
	 */
	public void deleteVetList(VetDetails vetToDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<VetDetails> typedQuery = em.createQuery("select detail from VetDetails detail where detail.id = :selectedId", VetDetails.class);
		
		typedQuery.setParameter("selectedId", vetToDelete.getId());
		
		typedQuery.setMaxResults(1);
		
		VetDetails result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
}
