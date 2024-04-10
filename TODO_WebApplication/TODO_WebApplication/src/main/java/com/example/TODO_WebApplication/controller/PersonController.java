package com.example.TODO_WebApplication.controller;

import com.example.TODO_WebApplication.model.Person;
import com.example.TODO_WebApplication.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        model.addAttribute("person", new Person()); // Add an empty Person object
        return "index";
    }

    @PostMapping("/addPerson")
    public String addPerson(@ModelAttribute Person person) {
        personRepository.save(person);
        return "redirect:/";
    }
}
