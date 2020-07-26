package com.example.postgrestomcat;

//import org.apache.catalina.Context;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PostgresTomcatApplication {

	public static void main(String[] args) throws Exception {

		SpringApplication.run(PostgresTomcatApplication.class, args);
	

	}





}



