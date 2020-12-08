package com.anamika.controller;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

public class Dao {

	public DataSource getDataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		try {
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://localhost:3306/springtest");
			dataSource.setUsername("root");
			dataSource.setPassword("root");

		} catch (Exception e) {
			e.printStackTrace();

		}
		return dataSource;
	}
}
