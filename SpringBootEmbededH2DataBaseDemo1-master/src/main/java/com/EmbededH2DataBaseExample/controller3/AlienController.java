package com.EmbededH2DataBaseExample.controller3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.EmbededH2DataBaseExample.demo1.AlienRepoDao;
import com.EmbededH2DataBaseExample.model2.Alien;

@Controller
public class AlienController {
	
	@Autowired	//9.
	AlienRepoDao alienRepoDao; //8.
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		
		System.out.println(alien);
		alienRepoDao.save(alien); //10.
		System.out.println(alien);
		return "home.jsp";
	}

}