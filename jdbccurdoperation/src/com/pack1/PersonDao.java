package com.pack1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
	public void saveperson(Person person) throws SQLException {
		Connection connection = TestConnection.createconnection();
		PreparedStatement preparedstatement = connection.prepareStatement("insert into Person values(?,?,?,?)");
		preparedstatement.setInt(1, person.getId());
		preparedstatement.setString(2, person.getFirstname());
		preparedstatement.setString(3, person.getLastname());
		preparedstatement.setString(4, person.getEmail());
		preparedstatement.executeUpdate();
		System.out.println("Data Inserted Succesfully");
	}

	public Person getPersonById(int id) throws SQLException {
		Connection connection = TestConnection.createconnection();
		Statement statement = connection.createStatement();
		ResultSet set = statement.executeQuery("select * from Person where id=" + id);
		set.next();
		Person person = new Person(set.getInt(1), set.getString(2), set.getString(3), set.getString(4));
		return person;
	}

	public List<Person> getPersonByFirstName(String firstname) throws SQLException {
		Connection connection = TestConnection.createconnection();
		Statement statement = connection.createStatement();
		ResultSet set = statement.executeQuery("select * from Person where firstname='" + firstname + "'");
		List<Person> persons = new ArrayList<Person>();
		while (set.next()) {
			Person person = new Person(set.getInt(1), set.getString(2), set.getString(3), set.getString(4));
			persons.add(person);
		}
		return persons;
	}

	public void deleteById(int id) throws SQLException {
		Connection connection = TestConnection.createconnection();
		Statement statement = connection.createStatement();
		int count = statement.executeUpdate("delete from Person where id=" + id);
		System.out.println("Data Deleted Successfully" + count);
	}

	public void updatebyFirstName(String firstname) throws SQLException {
		Connection connection = TestConnection.createconnection();
		Statement statement = connection.createStatement();
		int count = statement
				.executeUpdate("update Person set firstname = 'jaguar' where firstname ='" + firstname + "'");
		System.out.println("Data Updated Successfully" + count);

	}
}
