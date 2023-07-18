package com.tousif.SpringJDBCTemplateClass;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * @Spring_JDBC_FRAMEWORK_OVERVIEW
 * @see https://www.tutorialspoint.com/spring/spring_jdbc_framework.htm
 * 
 * 1.Add two more dependencies along with Spring dependencies :
 *   * mysql-connector-java
 *   * spring-jdbc
 * 
 * 1.Create Student Database :
 *    CREATE TABLE Student(
 *      ID   INT NOT NULL AUTO_INCREMENT,
 *      NAME VARCHAR(20) NOT NULL,
 *      AGE  INT NOT NULL,
 *      PRIMARY KEY (ID)
 *      );
 * 
 * 2.Create Student.java (POJO)
 * 
 * 3.Create StudentDao.java
 *   * Declare CRUD methods
 *   * Declare "setDataSource(DataSource ds)"
 *     --> This is the method to be used to initialize
 *         database resources ie. connection.
 *
 * 4.Create StudentMapper.java which "implements RowMapper<Student>"
 *    RowMapper :
 *    * An interface used by JdbcTemplate for mapping
 *      rows of a java.sql.ResultSet on a per-row basis.
 *    * Implementations of this interface perform the
 *      actual work of mapping each row to a result object
 * 
 * 5.Create StudentJDBCTemplate implements StudentDAO
 * 	 
 *   private DataSource dataSource;
 *	 private JdbcTemplate jdbcTemplateObject;
 *
 *	 public void setDataSource(DataSource dataSource) { //GETTING VALUE FROM Bean SETTER-INJECTION
 *		this.dataSource = dataSource;
 *      //Construct a new JdbcTemplate, given a DataSource to obtain connections from.
 *		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
 *	 }
 *  
 *  6.Bean Definations in XML :
 *  
 *  <!-- Definition for studentJDBCTemplate bean -->
 *  <bean id = "studentJDBCTemplate" 
 *     class = "com.tousif.SpringJDBCTemplateClass.StudentJDBCTemplate">
 *     <property name = "dataSource" ref = "dataSource" /> //SETTING dataSource in setDataSource()
 *  </bean>
 *  
 *  <bean id="dataSource" 
 *     class = "org.springframework.jdbc.datasource.DriverManagerDataSource">
 *     <property name = "driverClassName" value = "com.mysql.jdbc.Driver"/>
 *     <property name = "url" value = "jdbc:mysql://localhost:3306/demodb"/>
 *     <property name = "username" value = "root"/>
 *     <property name = "password" value = "admin"/>
 *   </bean>
 * 
 * 
 * @JDBC_TEMPLATE_CLASS
 * <p>The JDBC Template class executes SQL queries, updates statements,
 *    stores procedure calls, performs iteration over ResultSets, and
 *    extracts returned parameter values. It also catches JDBC exceptions
 *    and translates them to the generic, more informative, exception hierarchy 
 *    defined in the org.springframework.dao package.
 *    
 * <p>Instances of the JdbcTemplate class are threadsafe once configured.
 *    So you can configure a single instance of a JdbcTemplate and then safely
 *    inject this shared reference into multiple DAOs.
 *    
 * <p>A common practice when using the JDBC Template class is to configure a 
 *    DataSource in your Spring configuration file, and then dependency-inject
 *    that shared DataSource bean into your DAO classes, and the JdbcTemplate 
 *    is created in the setter for the DataSource.
 * 
 *    
 */
public class App 
{
	public static void main( String[] args )
	{
		System.out.println( "Hello World!" );
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringJDBCTemplateClass.xml");

		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");

		System.out.println("------Records Creation--------" );

		/**
		 *  String SQL = "insert into Student (name, age) values (?, ?)";
		 *  jdbcTemplateObject.update( SQL, name, age);
		 *   UPDATE
		 *    Issue a single SQL update operation 
		 *    (such as an insert, update or delete statement) 
		 *    via a prepared statement, binding the given arguments.
		 *    @Return : The number of rows affected
		 */
//		studentJDBCTemplate.create("Zara", 11);
//		studentJDBCTemplate.create("Nuha", 2);
//		studentJDBCTemplate.create("Ayan", 15);

		System.out.println("------Listing Multiple Records--------" );
		/**
		 *  String SQL = "select * from Student";
		 *  List <Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
		 *   QUERY
		 *    Execute a query given static SQL, mapping each row to a Java object via a RowMapper.
		 *    Uses a JDBC Statement, not a PreparedStatement.
		 *    @Return : The result List, containing mapped objects
		 */
		List<Student> students = studentJDBCTemplate.listStudents();

		for (Student record : students) {
			System.out.print("ID : " + record.getId()+"\n" );
			System.out.print("Name : " + record.getName()+"\n" );
			System.out.println("Age : " + record.getAge()+"\n");
		}

		System.out.println("----Updating Age with ID = 22 -----" );
		studentJDBCTemplate.update(22, 20);

		System.out.println("----Listing Record with ID = 22 -----" );
		Student student = studentJDBCTemplate.getStudent(22);
		System.out.print("ID : " + student.getId() );
		System.out.print(", Name : " + student.getName() );
		System.out.println(", Age : " + student.getAge());

	}
}
