/**
 * 
 */
package com.ss.basics.servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.ss.basics.pojo.User;

/**
 * @author jordandivina
 *
 */
@WebServlet(urlPatterns = {"/login", "/loginpage"})
public class LoginForm extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User adminUser = null;
	
	public void init() throws ServletException{
		this.adminUser = new User("Jordan", "root");
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (username.equals(this.adminUser.getUsername()) && password.equals(this.adminUser.getPassword())) {
			RequestDispatcher rd = request.getRequestDispatcher("success.html");
			rd.forward(request,response);
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("error.html");
			rd.include(request, response);
		}
		
		out.close();
	}	
}
