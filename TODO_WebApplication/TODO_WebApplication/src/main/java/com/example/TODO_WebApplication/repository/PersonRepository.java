package com.example.TODO_WebApplication.repository;


import com.example.TODO_WebApplication.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
