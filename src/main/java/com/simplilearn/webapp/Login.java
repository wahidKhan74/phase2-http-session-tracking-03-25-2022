package com.simplilearn.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    
    public Login() { }

    // load login page
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.getRequestDispatcher("index.jsp").include(request, response);
		request.getRequestDispatcher("login.html").include(request, response);
	}
	
	// submit login page
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// set the content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		// add navigation
		request.getRequestDispatcher("index.jsp").include(request, response);
				
		// read data fields from form submit
		String userId = request.getParameter("userId");
		String useremail = request.getParameter("useremail");
		String password = request.getParameter("password");
		
		if(useremail !=null && !useremail.equals("") && !password.equals("")) {
			if(useremail.equals("admin@gmail.com") && password.equals("admin@123")) { 
				// login success then create http  session
				HttpSession session = request.getSession(true);
				
				//add attribute in session 
				session.setAttribute("userId", userId);
				session.setAttribute("useremail", useremail);
				session.setAttribute("token", UUID.randomUUID().toString());
				
				out.println("<h3 style='color:green'>Login sucessfull ! for user '" + useremail + "' </h3>");
			} else {
				out.println("<h3 style='color:red'>Login Failed * Invalid credntials </h3>");
			}			
		} else {
			out.println("<h3 style='color:red'>Login Failed  * Required filled are missing! </h3>");
		}
		
	}

}
