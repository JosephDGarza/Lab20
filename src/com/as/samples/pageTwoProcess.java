package com.as.samples;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pageTwoProcess
 */
@WebServlet("/pageTwoProcess")
public class pageTwoProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String coffee=request.getParameter("coffee");
		String coffeeMonth=request.getParameter("coffeeMonth");
		String coffeeShops=request.getParameter("coffeeShops");
		String daysCoffee=request.getParameter("daysCoffee");
		String color=request.getParameter("color");
		
		//CONSOLE LOGS 
		System.out.println("You drink "+coffee + "cups of coffee daily");
		System.out.println("You go out to buy coffee "+coffeeMonth + "times a month");
		System.out.println(color);
		//Actually assigns the variable to the text from the website
		request.getSession().setAttribute("coffee", coffee);
		request.getSession().setAttribute("coffeeMonth", coffeeMonth);
		request.getSession().setAttribute("coffeeShops", coffeeShops);
		request.getSession().setAttribute("daysCoffee", daysCoffee);
		request.getSession().setAttribute("color", color);
		
		
		response.sendRedirect("jsp/printout.jsp");
		
	}

}
