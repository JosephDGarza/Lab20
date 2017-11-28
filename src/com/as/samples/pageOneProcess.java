package com.as.samples;
//FOLLOWED THE YOUTUBE VIDEO BELOW
//https://www.youtube.com/watch?v=kR-gaI0utQA
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

/**
 * Servlet implementation class pageOneProcess
 */
@WebServlet("/pageOneProcess")
public class pageOneProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String firstName=request.getParameter("firstName");
	String lastName=request.getParameter("lastName");
	String email=request.getParameter("email");
	String phoneNumber=request.getParameter("phoneNumber");
	String password=request.getParameter("password");
	
	
	//CONSOLE LOGS 
	System.out.println("Thank you for registering:" +firstName + " " + lastName);
	System.out.println("confirming your details:");
	System.out.println("Email address is :"+email);
	System.out.println("Phone number: " +phoneNumber);
	System.out.println("Make sure to write down your password!: " +password);
	
	//Actually assigns the variable to the text from the website
	request.getSession().setAttribute("firstName", firstName);
	request.getSession().setAttribute("lastName", lastName);
	request.getSession().setAttribute("email", email);
	request.getSession().setAttribute("phoneNumber", phoneNumber);
	request.getSession().setAttribute("password", password);
	
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coffeeshopdb","gcjdbc","gcjdbc");
		Statement stmt = (Statement) con.createStatement();
		stmt.execute("insert into users value('"+firstName+"','"+lastName+"','"+email+"','"+phoneNumber+"','"+password+"')");
		System.out.println("data inserted" + phoneNumber);
		
		
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	response.sendRedirect("html/pageTwo.html");
	
	}

}
