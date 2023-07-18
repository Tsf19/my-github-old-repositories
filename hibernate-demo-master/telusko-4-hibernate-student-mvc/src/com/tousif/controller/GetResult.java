package com.tousif.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tousif.model.Model;

/**
 * Servlet implementation class GetResult
 */
@WebServlet("/GetResultServlet")
public class GetResult extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) {

		
		int usn = Integer.parseInt(request.getParameter("usn"));
		System.out.println("Received usn in GetResult and usn is : "+usn);
		
		
		System.out.println("Creating Object of Model");
		Model m = new Model();
		
		m.setUsn(usn);
		
		m.getResult();
		
		String name = m.getName();
		int marks = m.getMarks();
		
		
		System.out.println("In GetResult USN :" + usn);
		
		System.out.println("In GetResult NAME :" + name);
		
		System.out.println("In GetResult MARKS" + marks);
		
		
		
		HttpSession hs = request.getSession(true);
		hs.setAttribute("USN", usn);
		hs.setAttribute("NAME", name);
		hs.setAttribute("MARKS", marks);
		
		try {
			//Give Full Path in sendRedirect
			System.out.println("Redirecting to ViewResult");
			response.sendRedirect("/HibernateStudentMVC/ViewResult.jsp");
			System.out.println("Redirected to ViewResult");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
