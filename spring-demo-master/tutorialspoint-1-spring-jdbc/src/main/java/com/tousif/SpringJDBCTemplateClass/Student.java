/**
 * 
 */
package com.tousif.SpringJDBCTemplateClass;

/**
 * @author Tousif
 *
 */
public class Student {

	private Integer age;
	private String name;
	private Integer id;

	public void setId(Integer id) {
		System.out.println("Inside setId()");
		this.id = id;
	}
	public Integer getId() {
		System.out.println("Inside getId()");
		return id;
	}

	public void setAge(Integer age) {
		System.out.println("Inside setAge()");
		this.age = age;
	}
	public Integer getAge() {
		System.out.println("Inside getAge()");
		return age;
	}

	public void setName(String name) {
		System.out.println("Inside setName()");
		this.name = name;
	}
	public String getName() {
		System.out.println("Inside getName()");
		return name;
	}

}