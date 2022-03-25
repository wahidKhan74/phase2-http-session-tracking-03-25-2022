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

@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Logout() {
	}

	// cookie based logout
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("index.jsp").include(request, response);
		
		out.println("<h3 style='color:green'>Sucessfull logout, Please login again ... </h3>");
		// get http session
		HttpSession session = request.getSession(false);
		session.invalidate();
		
		// add navigation
		
		request.getRequestDispatcher("login.html").include(request, response);

		
	}

	// submit logout page
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
