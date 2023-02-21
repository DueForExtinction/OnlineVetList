/**
 * 
 */
package webVetList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Brandon Thompson - Brandon Thompson
 *CIS175 - Spring 2023
 * Feb 19, 2023
 */
@Entity
@Table(name="veterinarian")
public class Veterinarian {
	@Id
	@GeneratedValue
	private int id;
	private String vetName;
	
	public Veterinarian() {
		super();
	}
	
	public Veterinarian(int id, String vetName) {
		super();
		this.id = id;
		this.vetName = vetName;
	}
	
	public Veterinarian(String vetName) {
		this.vetName = vetName;
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
	 * @return the vetName
	 */
	public String getVetName() {
		return vetName;
	}

	/**
	 * @param vetName the vetName to set
	 */
	public void setVetName(String vetName) {
		this.vetName = vetName;
	}

	@Override
	public String toString() {
		return "Veterinarian [id=" + id + ", vetName=" + vetName + "]";
	}
	
	
}
