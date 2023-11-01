package com.xworkz.street;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Car {

	public static void main(String[] args) {
		findOneRecord();
		findAllRecords();
	}

	public static void findOneRecord() {
		System.out.println("Find one record");

		String jdbcUrl = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "Xworkzodc@123";

		String driverClass = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		System.out.println("Getting connection to database");
		String fetchOneRecord = "Select * from bank where id=1";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Connection established");
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(fetchOneRecord);
			if (set.next()) {
				System.out.println(set.getString("name"));
			} else {
				System.err.println("No records found for id 1");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void findAllRecords() {

		System.out.println("Find all records");

		String jdbcUrl = "jdbc:mysql://localhost:3306/jdbc";
		String username = "root";
		String password = "Xworkzodc@123";

		String driverClass = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		System.out.println("Getting connection to database");
		String fetchAllRecords = "Select * from bank";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, username, password);
			System.out.println("Connection established");
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(fetchAllRecords);
			while (set.next()) {
				System.out.println(set.getString(2));
				System.out.println(set.getString(4));
				System.out.println(set.getString("location"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
