/**
 * 
 */
package webVetList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Brandon Thompson - Brandon Thompson
 *CIS175 - Spring 2023
 * Feb 19, 2023
 */
@Entity
public class VetDetails {
	@Id
	@GeneratedValue
	private int id;
	private String vetBisName;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Veterinarian veterinarian;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<PetItem> petInfo;
	
	
	public VetDetails() {
		// You can't have the super call here because it messes with the jsp file call.
	}


	public VetDetails(int id, String vetBisName, Veterinarian veterinarian, List<PetItem> petInfo) {
		
		this.id = id;
		this.vetBisName = vetBisName;
		this.veterinarian = veterinarian;
		this.petInfo = petInfo;
	}


	public VetDetails(String vetBisName, Veterinarian veterinarian, List<PetItem> petInfo) {
		
		this.vetBisName = vetBisName;
		this.veterinarian = veterinarian;
		this.petInfo = petInfo;
	}


	public VetDetails(String vetBisName, Veterinarian veterinarian) {
		
		this.vetBisName = vetBisName;
		this.veterinarian = veterinarian;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the vetBisName
	 */
	public String getVetBisName() {
		return vetBisName;
	}


	/**
	 * @param vetBisName the vetBisName to set
	 */
	public void setVetBisName(String vetBisName) {
		this.vetBisName = vetBisName;
	}


	/**
	 * @return the veterinarian
	 */
	public Veterinarian getVeterinarian() {
		return veterinarian;
	}


	/**
	 * @param veterinarian the veterinarian to set
	 */
	public void setVeterinarian(Veterinarian veterinarian) {
		this.veterinarian = veterinarian;
	}


	/**
	 * @return the petInfo
	 */
	public List<PetItem> getPetInfo() {
		return petInfo;
	}


	/**
	 * @param petInfo the petInfo to set
	 */
	public void setPetInfo(List<PetItem> petInfo) {
		this.petInfo = petInfo;
	}


	@Override
	public String toString() {
		return "VetDetails [id=" + id + ", vetBisName=" + vetBisName + ", veterinarian=" + veterinarian + ", petInfo="
				+ petInfo + "]";
	}
	
	
}
