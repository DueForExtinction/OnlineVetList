/**
 * 
 */
package webVetList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Brandon Thompson - Brandon Thompson
 *CIS175 - Spring 2023
 * Feb 9, 2023
 */
@Entity
@Table(name="pets")
public class PetItem {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="OWNER")
	private String owner;
	@Column(name="OPERATION")
	private String operation;
	
	public PetItem(){
		
	}
	
	public PetItem(String name,String owner, String operation){
		this.name = name;
		this.owner = owner;
		this.operation = operation;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the procedure
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * @param procedure the procedure to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "Pet: " + getName() + "\nOwner: " + getOwner() + "\nOperation: " + getOperation();
	}
	
	
	
}
