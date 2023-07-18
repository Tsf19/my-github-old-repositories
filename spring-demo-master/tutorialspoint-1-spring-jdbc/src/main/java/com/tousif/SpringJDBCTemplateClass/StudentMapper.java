/**
 * 
 */
package com.tousif.SpringJDBCTemplateClass;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author Tousif
 *
 */


public class StudentMapper implements RowMapper<Student> {
	
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		System.out.println("Inside mapRow() and value of rowNum is : "+rowNum);
		
		Student student = new Student();
		
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setAge(rs.getInt("age"));

		return student;
	}
}
