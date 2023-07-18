package com.tousif.HibernateMappingRelations;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Laptop {

	@Id
	private int lid;
	
	@Column(name = "laptop_name")
	private String lname;
	
//	3.
//	@ManyToOne	//Many Laptop belong to One Student, With This Mapping will be Done Inside LaptopTable
//	private Student student; //Laptop should also know about their Owner(Student)
//	This will create "student_rollno" as foreignKey in LaptopTable, now Laptop also knows about Student
	
//	(Ref.3)Now, we won't need that extra table(MappingTable) "Student_Laptop"(Ref.2) , as Both Tables have their respective mapping
//	But still It's creating an extra table(MappingTable) "Student_Laptop" , WHY??
	
//	Bcz Laptop thinks he is responsible to map and Student thinks he is responsible to map
//	So we have to mention, Hey Student, you don't have to map it, it'll be mapped by "student variable of Laptop Class" (ref.4)

//	5.
	@ManyToMany //As One Laptop belong to Many Students AND One Student has many Laptops , Therefore Change @ManyToOne to @ManyToMany
	private List<Student> student = new ArrayList<Student>(); //Now One Laptop belong to Many Students.
	
	
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
	
	
}
