package com.example.jsfdemo;


import org.springframework.beans.factory.config.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.*;

import java.util.*;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class JSFDemoApplication {
	public static void main(String[] args) throws Exception {

		SpringApplication.run(JSFDemoApplication.class, args);
	

	}




}



