package com.tousif.HibernateMappingRelations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {

	@Id
	private int rollno;
	
	@Column(name = "student_name")
	private String name;
	
	@Column(name = "student_marks")
	private int marks;
	
//	1.
//	@OneToOne //Defining the Relationship Type of Laptop with Student, Otherwise ERROR, Need to define what type
//	private Laptop laptop; //will create laptop_lid as foreignKey in StudentTable if @OneToOne is used, bcz Student knows about Laptop


//  2.
//	@OneToMany //Now, One Student Will Have Many Laptop
//	private List<Laptop> laptop = new ArrayList<Laptop>();
//  This will create an extra table(MappingTable) "Student_Laptop" with both's table PrimaryKey,
//  as One Student has many Laptops so we can't map them in "StudentTable"
	
//	4.
//	@OneToMany(mappedBy="student") // it'll be mapped by "student variable of Laptop Class" , Now it won't create an extra MappingTable "Student_Laptop"
//	private List<Laptop> laptop = new ArrayList<Laptop>();

	
//	6.
//	@ManyToMany
//	private List<Laptop> laptop = new ArrayList<Laptop>();
//	It will create TWO extra MappingTables "Student_Laptop" AND "Laptop_Student" , WHY??	
//	Bcz Laptop thinks he is responsible to map and Student thinks he is responsible to map
//	So we have to mention, Hey Student, you don't have to map it, it'll be mapped by "student variable of Laptop Class" (ref.4)

//	7.
	@ManyToMany(mappedBy="student") // it'll be mapped by "student variable of Laptop Class"
	private List<Laptop> laptop = new ArrayList<Laptop>();
//	Now it won't create TWO EXTRA MappingTables, It will JUST ONE EXTRA MappingTable "Laptop_Student" to MAP Relation ManyToMany
	
	
	
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
	public List<Laptop> getLaptop() {
		return laptop;
	}
	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}
	
	
	
	
}
