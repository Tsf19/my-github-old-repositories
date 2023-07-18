package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

//import oracle.jdbc.OracleDriver;
/*import oracle.jdbc.driver.OracleDriver;*/ // METHOD 1, Using import statement

public class BasicFetching {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null ;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		//STEP 1 - LOADING THE DIVER
		System.out.println("STEP 1 - LOADING THE DIVER");
		
		// METHOD 1, Using import statement
		/*try {
			DriverManager.registerDriver(new OracleDriver());
			System.out.println("Driver Loaded Successfully By Method 1");
			}catch(SQLException e) {
				System.out.println("Driver Loading Failed By Method 1");
			}*/ 

		// METHOD 2, Using FULLY QUALIFIED CLASS NAME
		/*try {
			//DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			System.out.println("Driver Loaded Successfully By Method 2");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Driver Loading Failed By Method 2");
		}*/
		
		// METHOD 3, Using forName(), which belong to class Class,
		// It will not result in SQLException,
		// It may result in ClassNotFoundException
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded Successfully By Method 3");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver Loading Failed By Method 3");
		}

		
		//STEP 2 - ESTABLISHING THE CONNECTION WITH DATABASE
		System.out.println("STEP 2 - ESTABLISHING THE CONNECTION WITH DATABASE");
		
		try {
			//con = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:orcl","system","orcl123");
			//con = DriverManager.getConnection("jdbc:Oracle:thin:192.168.1.11:1521:orcl","system","orcl123");
			
		con = DriverManager.getConnection("jdbc:Oracle:thin:@//localhost:1521/newpdb","Tousif","Tousif");
			
		// From Oracle 12CR2 : "jdbc : Oracle : thin : @localhost or IPA4 : PortNo / ServiceName ", "UN","PW"
		//not PW@PluggableDatabaseName
		
		// OLD WAY : jdbc : Oracle : TYPE4 : @//IPA : PA / ExpressEdition ", "UserName", "Password"
			System.out.println("Connection Established with Database Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection Establishing with Database Failed");
		}
		
		//STEP 3 - EXECUTING THE QUERY & STORING it into ResultSet rs 
		System.out.println("EXECUTING THE QUERY & STORING it into ResultSet rs");
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM JULYSTUDENTS");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Query Executed Successfully");
		
		//STEP 4 - FETCHING THE ResultSetMetaData
		System.out.println("FETCHING THE ResultSetMetaData");
		
		
		try {
			rsmd = rs.getMetaData();
			
			for(int i=1; i<=rsmd.getColumnCount(); i++) {
				System.out.println(rsmd.getColumnName(i)+" "+rsmd.getColumnType(i));
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		//STEP 5 - FETCHING THE DATA
		System.out.println("FETCHING THE DATA");
		
		try {
			while(rs.next()==true) {
				//WE CAN USE INDEX NUMBER AsWellAs COLUMN NAME
				String a = rs.getString(1);
				//String a = rs.getString("USN");
				String b = rs.getString(2);
				//String b = rs.getString("Name");
				int c = rs.getInt(3);
				//int c = rs.getInt("Marks1");
				int d = rs.getInt(4);
				//int d = rs.getInt("Marks2");
				int e = rs.getInt(5);
				//int e = rs.getInt("Marks3");
				float f = rs.getFloat(6);
				//float f = rs.getFloat("AVG");
				
				System.out.println(a+"\t"+b+"\t"+c+"\t"+d+"\t"+e+"\t"+f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		// INSERTING A ROW INTO DATABASE AND PRINTING TABLE
		
		try {
			PreparedStatement pstmt = con.prepareStatement("INSERT into JulyStudents VALUES (?, ?, ?, ?, ?, ?)");
			Scanner sc=new Scanner(System.in);
			
			System.out.println("Enter USN");
			String usn=sc.next();
			System.out.println("Enter Name");
			String name=sc.next();
			System.out.println("Enter Marks1");
			int m1 = sc.nextInt();
			System.out.println("Enter Marks2");
			int m2 = sc.nextInt();
			System.out.println("Enter Marks3");
			int m3 = sc.nextInt();
			System.out.println("Enter Average");
			float avg = sc.nextFloat();
			
			pstmt.setString(1, usn);
			pstmt.setString(2, name);
			pstmt.setInt(3, m1);
			pstmt.setInt(4, m2);
			pstmt.setInt(5, m3);
			pstmt.setFloat(6, avg);
			
			pstmt.executeUpdate();
			
			System.out.println("Inserting Row Successfull");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM JULYSTUDENTS");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("PRINTING THE DATA ALONG WITH NEW ROW");
		
		try {
			while(rs.next()==true) {
				//WE CAN USE INDEX NUMBER AsWellAs COLUMN NAME
				String a = rs.getString(1);
				//String a = rs.getString("USN");
				String b = rs.getString(2);
				//String b = rs.getString("Name");
				int c = rs.getInt(3);
				//int c = rs.getInt("Marks1");
				int d = rs.getInt(4);
				//int d = rs.getInt("Marks2");
				int e = rs.getInt(5);
				//int e = rs.getInt("Marks3");
				float f = rs.getFloat(6);
				//float f = rs.getFloat("AVG");
				
				System.out.println(a+"\t"+b+"\t"+c+"\t"+d+"\t"+e+"\t"+f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
