package com.mahi.em;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.mahi.em.entity.User;

@SpringBootApplication
@EnableScheduling
public class ExpenseMangerApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ExpenseMangerApplication.class, args);
		User u=new User();
		
	}

}
