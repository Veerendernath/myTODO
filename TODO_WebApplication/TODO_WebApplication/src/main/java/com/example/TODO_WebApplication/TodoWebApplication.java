package com.example.TODO_WebApplication;

import com.example.TODO_WebApplication.model.Person;
import com.example.TODO_WebApplication.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoWebApplication implements ApplicationRunner {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoWebApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		addRandomPersons(5); // Add 5 random persons initially
	}

	private void addRandomPersons(int count) {
		String[] firstNames = {"John", "Jane", "Alice", "Bob", "Michael", "Emily", "David", "Sarah"};
		String[] lastNames = {"Doe", "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Martinez"};

		for (int i = 0; i < count; i++) {
			String firstName = firstNames[(int) (Math.random() * firstNames.length)];
			String lastName = lastNames[(int) (Math.random() * lastNames.length)];

			Person person = new Person(firstName, lastName);
			personRepository.save(person);
		}
	}
}
