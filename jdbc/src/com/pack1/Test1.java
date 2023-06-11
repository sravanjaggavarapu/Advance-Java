package com.pack1;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// STEP-1 Load the driver

		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver Class Loaded Successfully ");

		// STEP-2 Create The Connection

		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "sravan");
		System.out.println("Connection Succesfull : " + connection);

		// STEP-3 Process The Queries

		Statement statement = connection.createStatement();
		int x = statement.executeUpdate("create table emps(empid number,empname varchar2(20),empsal number)");
		System.out.println("Table Created Successfully : " + x);

		int r1 = statement.executeUpdate("insert into emps values(111,'mr.ratan',100000.45)");
		int r2 = statement.executeUpdate("insert into emps values(222,'mr.rao',200000.45)");
		int r3 = statement.executeUpdate("insert into emps values(333,'mr.ajay',300000.45)");
		System.out.println(r1 + " " + r2 + " " + r3);
		
		int count = statement.executeUpdate("update emps set empsal=empsal+400 where empsal>200000");
		System.out.println("Records updated : "+count);
		
		int delcount = statement.executeUpdate("delete emps where empsal<250000");
		System.out.println("Records deleted : "+delcount);

		int s = statement.executeUpdate("drop table emps");
		System.out.println("Records Dropped successfully : "+s);


		
		// STEP-4 Close The Resource
		connection.close();
		System.out.println("Connection Released Succesfully");
	}

}
