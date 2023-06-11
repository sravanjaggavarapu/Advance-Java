package com.pack.number;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NumberServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		String operation = request.getParameter("operation");
		RequestDispatcher dispatcher = request.getRequestDispatcher("number.html");
		dispatcher.include(request, response);
		switch (operation) {
		case "Even":
			for (int i = start; i <= end; i++) {
				if (i % 2 == 0) {
					writer.println(i);
				}
			}
			break;

		case "odd":
			for (int i = start; i <= end; i++) {
				if (i % 2 != 0) {
					writer.println(i);
				}
			}
			break;
		case "Perfect":
			for (int i = start; i <= end; i++) {
				int sum = 0;
				for (int j = 1; j <= i / 2; j++) {
					if (i % j == 0)
						sum = sum + j;
				}
				if (sum == i)
					writer.println(i);
			}
			break;

		case "Prime":
			writer.println("Prime Numbers Between " + start + " & " + end + " are ");
			for (int i = start; i <= end; i++) {
				int count = 0;
				for (int j = 1; j <= i; j++) {
					if (i % j == 0)
						count++;
				}
				if (count == 2)
					writer.println(i);
			}

			break;
		case "Lucky":
			int n = (start + end) / 2;
			int og = n;
			int sum = 0;
			while (n > 0) {
				int r = n % 10;
				sum = sum + r;
				n = n / 10;
			}
			int sum1 = 0;
			while (sum > 0) {
				int r1 = sum % 10;
				sum1 = sum1 + r1;
				sum = sum / 10;
			}
			writer.println("Number Between " + start + " & " + end + " is " + og);
			writer.println("Lucky Number : " + sum1);
			break;
		}

	}

}
