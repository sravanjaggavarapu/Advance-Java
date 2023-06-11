package com.pack.calculator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		String name = request.getParameter("name");
		double cost = Integer.parseInt(request.getParameter("cost"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		double totalbill=cost*quantity;
		double discount;
		double netAmount;
		if (totalbill>10000) {
			discount=0.15*totalbill;
			netAmount=totalbill-discount;
		}
		else if (totalbill>10000) {
			discount=0.1*totalbill;
			netAmount=totalbill-discount;
		}
		else if (totalbill>10000) {
			discount=0.05*totalbill;
			netAmount=totalbill-discount;
		}
		else {
			discount=0;
			netAmount=totalbill-discount;
		}
		
		writer.println("<html><body bgcolor='gold' style='text-align: center;'>");
		writer.println("<h1>Product Bill Calculator Result</h1>");
		writer.println("<br>");
		writer.println("Total cost of "+quantity+" "+name+" : "+totalbill);
		writer.println("<br><br>");
		writer.println("Discount Amount : "+discount);
		writer.println("<br><br>");
		writer.println("Net Amount to pay : "+netAmount);
		
	}

}
