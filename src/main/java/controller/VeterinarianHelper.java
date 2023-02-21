/**
 * 
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import webVetList.Veterinarian;

/**
 * @author Brandon Thompson - Brandon Thompson
 *CIS175 - Spring 2023
 * Feb 19, 2023
 */
public class VeterinarianHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("webVetList");
	
	public void insertVet(Veterinarian v) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Veterinarian> showAllVets(){
		EntityManager em = emfactory.createEntityManager();
		List<Veterinarian> allVeterinarians = em.createQuery("SELECT v FROM Veterinarian v").getResultList();
		return allVeterinarians;
	}
	
}
