package com.example.demo;

//import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class PersonController {

    private Person person;
    List<Person> personList = new ArrayList<>();

    @Autowired
    private PersonRepository personRepository;

    @PostMapping("/person")
    public String setPersonList(@RequestBody Person person) {

        personRepository.save(person);
        return "Added person with id: " + person.getId();

    }


    @GetMapping("/person")
    public List<Person> fetchAllPersons() {
        return personRepository.findAll();

    }


    @GetMapping("add/person")
    public String setPersonList() {
        return "<form method=POST action=/api/person>" +
                "<h4>ID   <input type=text name=id ></h4></br>" +
                "<h4>Name <input type=text name=name required></h4></br>" +
                "<h4>Email<input type=text name=email required></h4></br>" +
                "<h4>Age  <input type=number name=age required></h4></br>" +
                "<input type=submit value=submit>" +
                "</form>";
    }

}


