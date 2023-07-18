/**
 * 
 */
package com.tousif.SpringJDBCTemplateClass;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
/**
 * @author Tousif
 *
 */
public class StudentJDBCTemplate implements StudentDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		System.out.println("Inside setDataSource()");
		this.dataSource = dataSource;
		//Construct a new JdbcTemplate, given a DataSource to obtain connections from.
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void create(String name, Integer age) {

		System.out.println("Inside create()");

		String SQL = "insert into Student (name, age) values (?, ?)";
		jdbcTemplateObject.update( SQL, name, age);

		System.out.println("Created Record Name = " + name + " Age = " + age);

		return;
	}

	public Student getStudent(Integer id) {
		System.out.println("Inside getStudent()");
		String SQL = "select * from Student where id = ?";
		Student student = jdbcTemplateObject.queryForObject(SQL, new Object[]{id}, new StudentMapper());
		return student;	}

	public List<Student> listStudents() {
		System.out.println("Inside listStudents()");
		String SQL = "select * from Student";
		List <Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
		return students;		
	}

	public void delete(Integer id) {
		System.out.println("Inside delete()");
		String SQL = "delete from Student where id = ?";
		jdbcTemplateObject.update(SQL, id);
		System.out.println("Deleted Record with ID = " + id );
		return;

	}

	public void update(Integer id, Integer age) {
		System.out.println("Inside update()");
		String SQL = "update Student set age = ? where id = ?";
		jdbcTemplateObject.update(SQL, age, id);
		System.out.println("Updated Record with ID = " + id );
		return;
	}

}
