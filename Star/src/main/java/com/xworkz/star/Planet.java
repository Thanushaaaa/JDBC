package com.xworkz.star;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Planet {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "Xworkzodc@123";

		String driverClass = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driverClass);
		}

		catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		System.out.println("Getting connection to database");

		String insertQuery = "Insert into bank values(1,'ICICI','Jayanagar','Karnataka')";
		String insertQuery1 = "Insert into bank values(2,'Axis','BTM','Karnataka')";
		String insertQuery2 = "Insert into bank values(3,'canara','JP nagar','Karnataka')";
		String updateQuery = "Update bank set name='SBI' where id=1";
		String deleteQuery = "Delete from bank where location='JP nagar'";

		try {

			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Connection established");
			Statement stmt = con.createStatement();
			stmt.execute(insertQuery);
			System.out.println("Executed insert query");
			stmt.execute(insertQuery1);
			System.out.println("Executed insert query1");
			stmt.execute(insertQuery2);
			System.out.println("Executed insert query2");
			stmt.execute(updateQuery);
			System.out.println("Executed update query");
			stmt.execute(deleteQuery);
			System.out.println("Executed delete query");

		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
