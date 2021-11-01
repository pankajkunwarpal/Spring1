package com.example.demo;

import com.example.demo.Person;
import com.example.demo.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(PersonRepository repository) {
//		return args -> {
//			Person person = new Person("Bruce Wane", "Batman@email.com", 37);
//
//			repository.insert(person);
//
////			repository.findPersonById(2).ifPresentOrElse(person1 -> {
////				System.out.println(person1 + " already exist");
////			}, () -> {
////				System.out.println("Inserting person" + person);
////				repository.insert(person);
////			});
//		};
//	}
}
