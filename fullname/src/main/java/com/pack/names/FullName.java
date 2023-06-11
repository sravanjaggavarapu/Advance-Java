package com.pack.names;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FullName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		writer.println("<html><body bgcolor='gold' style='text-align: center;'/>");
		writer.println("<h1 style='color : red'>This is FullName Application</h1>");
		writer.println("<p style='color:blue'>FullName : </p>"+(FirstName+" "+LastName));
		writer.println("</html></body>");
	}

}
