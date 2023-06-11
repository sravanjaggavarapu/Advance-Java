package com.pack.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/plain");

		String username = request.getParameter("Username");
		String password = request.getParameter("Password");

		if (username.equals("sravan") && password.equals("sravan@1")) {
			writer.println("Login Successful " + username);
		} else
			writer.println("Login Failed " + username);

	}

}
