package com.simplilearn.webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Profile() {
	}

	// load profile page
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// add navigation
		request.getRequestDispatcher("index.jsp").include(request, response);
		
		// read http session
		
		HttpSession session = request.getSession(false);
		
		String useremail = (String) session.getAttribute("useremail");
		String userId = (String) session.getAttribute("userId");
		String token = (String) session.getAttribute("token");
		
		if ( session !=null && useremail!=null) {
		
			
			if (useremail.equals("admin@gmail.com")) {
				out.println("<h3 style='color:green'> Welcome to user profile '" + useremail + "' </h3>");
				out.println("<p> User ID : "+userId+"</p>");
				out.println("<p> Token : "+token+"</p>");
			} else {
				out.println("<h3 style='color:red'>Login Failed * Invalid credntials </h3>");
			}
		} else {
			out.println("<h3 style='color:red'>Invalid access, please login to see profile ! </h3>");
		}
	}

	// submit profile page
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
