package com.EmbededH2DataBaseExample.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.EmbededH2DataBaseExample.controller3.AlienController;


@SpringBootApplication
@EntityScan(basePackages = {"com.EmbededH2DataBaseExample.model2"}) //11. This will help to "find Alien.java"
//@EnableConfigurationProperties
//@ComponentScan(basePackageClasses = AlienController.class) //12.	This will help to find "AlienController.java"
//								OR
//@ComponentScan(basePackages = {"com.EmbededH2DataBaseExample.controller3"}) //WORKING
//						INCLUDING BOTH BASE_PACKAGES
//@ComponentScan(basePackages = {"com"}) //WORKING
//								OR
//@ComponentScan(basePackageClasses = {AlienController.class, AlienRepoDao.class})//WORLING
//								OR
//@ComponentScan(basePackages = {"com.EmbededH2DataBaseExample.controller3", "com.EmbededH2DataBaseExample.dao4.AlienRepoDao"}) //WORLING
//								OR
@ComponentScan(basePackages = {"com.EmbededH2DataBaseExample.controller3", "com.EmbededH2DataBaseExample.dao4"}) //NOT WORLING
public class SpringBootEmbededH2DataBaseDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmbededH2DataBaseDemo1Application.class, args);
		
		System.out.println("Hello SpringBootEmbededH2DataBaseDemo1Application");
		
//		1. While Creating Project, choose Three "Available:" things i)web  ,  ii)H2(under SQL) & iii)JPS
//		2. Add tomcat-jasper to support JSP in pom.xml
//		3. Edit src/main/resources/"application.properties" file
//		4.http://localhost:8080/h2-console //Go to Console of H2 DataBase
//		5.Add dependency : // (If didn't selected JPA)
//				<dependency>
//        			<groupId>org.springframework.boot</groupId>
//        			<artifactId>spring-boot-starter-data-jpa</artifactId>
//        		</dependency>
//		6. Create "data.sql" in src/main/resources
//		7. Create "AlienRepoDao & extends CrudRepository" in "package com.EmbededH2DataBaseExample.dao3"
		
		
		
	}

}

