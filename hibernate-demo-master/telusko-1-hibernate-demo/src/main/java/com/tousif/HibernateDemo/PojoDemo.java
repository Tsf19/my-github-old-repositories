package com.tousif.HibernateDemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity	//To Tell That This Class is Entity, Hence Store it's Object inside the DataBase
@Table(name = "Student_Details") //TableName is "student_details", Otherwise "PojoDemo" (ClassName)
public class PojoDemo {	//POJO
	
/* 
 * 								DIFFERENT ANNOTATIONS 
 * 
 * @Entity(name = "anyName") : It'll give Table Name as Specified(anyName), not the default ClassName(PojoDemo)
 * 
 * There Are 3 Layers, 1.ClassName 2.EntityName 3.TableName
 * 
 * If we Don't Want to Change EntityName, we can make us of other annotation just above the Class as follow :
 * 
 * @Table(name="anyName") : now, Table name will be derived from here, not from EntityName
 *
 *
 * @Column(name="anyName") : Use to Change ColumnName, use just above attribute(column) name
 *  ex:
 *  	@Column(name="First_Name")	
 *  	private String firstName;
 * 
 * 
 * @Transient : Use above Variable name of which you don't want to store, then this won't create any column for that variable
 * 
 * 
 * @Embeddable : We use this to Embed a composite Attribute to embed inside Table
 * 				Eg.	name(firstName, middleName, lastName)
 * 					address(street, city, state)
 * 
 * */	
	
	
	@Id //Specify PrimaryKey
	private int id; //PrimaryKey, Every Table must have an PK
	
	@Column(name="first_name")
	private String firstName;
	
	@Transient
	private String middleName;
	
	@Column(name="last_name")
	private String lastName;
	
	private Address address;	//Composite Attribute
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String middleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "PojoDemo [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", address=" + address + "]";
	}

	
	

}
