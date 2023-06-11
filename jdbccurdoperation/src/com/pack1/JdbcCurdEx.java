package com.pack1;

import java.sql.SQLException;
import java.util.List;

public class JdbcCurdEx {

	public static void main(String[] args) throws SQLException {
		Person person = new Person(111, "sravan", "kumar", "sravan@gmail.com");
		PersonDao dao = new PersonDao();
		dao.saveperson(person);
		Person p = dao.getPersonById(111);
		System.out.println(p);
		List<Person> persons = dao.getPersonByFirstName("sravan");
		persons.forEach(per -> System.out.println(per));
		dao.deleteById(222);
		dao.updatebyFirstName("dheeraj");
	}

}
