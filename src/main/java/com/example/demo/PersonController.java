package com.example.demo;

//import lombok.AllArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PersonController {

    private final List<Person> personList = new ArrayList<>();
    private PersonRepository personRepository;

    @GetMapping("/persons")
    public List<Person> fetchAllPersons() {
        return personRepository.findAll();
    }

    @GetMapping("/person")
    public List<List<Person>> person() {
        System.out.println("INSIDE GET ");

//        return this.personRepository.findAll();
        return List.of(personList);
    }

    @PostMapping("/person")
    public String setPersonList(int id, String name, String email, int age) {
        System.out.println("INSIDE POST MAPPING");

        this.personList.add(new Person(id, name, email, age));
        return personList.toString();
    }

    @GetMapping("add/person")
    public String setPersonList() {
        return "<form method=POST action=/api/person>" +
                "<h4>ID</h4><input type=number name=id required></br>" +
                "<h4>Name</h4><input type=text name=name required></br>" +
                "<h4>Email</h4><input type=text name=email required></br>" +
                "<h4>Age</h4><input type=number name=age required></br>" +
                "<input type=submit value=submit>" +
                "</form>";
    }

}


