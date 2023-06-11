package com.pack1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Class Loaded Successfully ");

		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "sravan");
		System.out.println("Connection Succesfull : " + connection);

		Statement statement = connection.createStatement();
		int x = statement.executeUpdate("create table emp(empid number,empname varchar2(20),empsal number)");
		System.out.println("Table Created Successfully : " + x);
		int id;
		String name;
		double salary = 0;
		while (true) {
			try {
				System.out.println("Enter Employee id :");
				id = sc.nextInt();
				System.out.println("Enter Employee name : ");
				name = sc.next();
				System.out.println("Enter Employee salary :");
				salary = sc.nextDouble();
			} catch (InputMismatchException e) {
				sc.next();
				System.out.println("invalid format please enter again");
				continue;
			}
			int r1 = statement.executeUpdate("insert into emp values(" + id + ",'" + name + "'," + salary + ")");
			System.out.println("Records uploaded Succesfully : " + r1);
			System.out.println("Do you Want to insert Again (yes/no)");
			String n = sc.next();
			if (n.equalsIgnoreCase("no"))
				break;
		}
		/*
		 * int s = statement.executeUpdate("drop table emps");
		 * System.out.println("Records Dropped successfully : " + s);
		 */
		connection.close();
		System.out.println("Connection Released Succesfully");
		sc.close();
	}

}
