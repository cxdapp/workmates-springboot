package com.wokemates;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.util.Date;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner setup(BookRepository bookRepository) {
//		return (args)->{
//			bookRepository.save(new Book("Sherlock", "Holmes", true,new Timestamp(new Date().getTime()),new java.sql.Date(new Date().getTime()),new Date()));
//			bookRepository.save(new Book("Sherlock2", "Holmes", true,new Timestamp(new Date().getTime()),new java.sql.Date(new Date().getTime()),new Date()));
//			bookRepository.save(new Book("Sherlock3", "Holmes", true,new Timestamp(new Date().getTime()),new java.sql.Date(new Date().getTime()),new Date()));
//			bookRepository.save(new Book("Sherlock4", "Holmes", true,new Timestamp(new Date().getTime()),new java.sql.Date(new Date().getTime()),new Date()));
//			bookRepository.save(new Book("Sherlock5", "Holmes", true,new Timestamp(new Date().getTime()),new java.sql.Date(new Date().getTime()),new Date()));
//			bookRepository.save(new Book("Sherlock6", "Holmes", true,new Timestamp(new Date().getTime()),new java.sql.Date(new Date().getTime()),new Date()));
//		};
//	}
}
