package com.yaroslavl.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
//	static {
//		try {
////			DriverManager.registerDriver(new org.postgresql.Driver());
//			Class.forName("org.postgresql.Driver");
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException("Failed to load PostgreSQL JDBC driver", e);
//		}
//	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
