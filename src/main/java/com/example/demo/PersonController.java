package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
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
    /*
    Accept Post request with Person object with or without
    person id; person id can be automatically generated.
     */
    @PostMapping("/person")
    public String setPersonList(@RequestBody Person person) {

        personRepository.save(person);
        return "Added person with id: " + person.getId();

    }

    /*
    Accept Get request to and display all person entity
    stored in the database.
     */

    @GetMapping("/person")
    public List<Person> fetchAllPersons() {
        return personRepository.findAll();

    }

    /*
    Accept Post request from Form and add person object
    in the database.

     */

    @PostMapping("add/person")
    public String addPerson(String id, String name, String email, int age) {
        setPersonList(new Person(id, name, email, age));
        return name + " Added successfully";
    }

    /*
    Accept delete request to delete entity from database
    if present else return unsuccessful error.
     */


    @DeleteMapping("delete")
    public String deletePerson(String id) {
//        return String.format("person with id %s is %s", id, personRepository.findPersonById(id).getName());
        try {
            personRepository.delete(personRepository.findPersonById(id));
            return "Person with id: " + id + " deleted";
        } catch (Exception e) {
            e.printStackTrace();
            return "delete operation unsuccessful";
        }
    }

    /*
    Accept Put request and update the person entity name
    with the provided id in the request with specified name.
     */

    @PutMapping("update/{id}")
    public String updatePerson(@PathVariable String id, @RequestParam(value = "name", defaultValue = "Unknown Person") String name) {

        Person p = personRepository.findPersonById(id);
        String person = p.getName();
        p.setName(name);

        personRepository.save(p);

        return String.format("Person with name %s changed to %s", person, p.getName());
    }

    /*
    Accept Get request and send Form with Post method and
    add person entity in database.
     */

    @GetMapping("add/person")
    public String setPersonList() {
        return "<form method=POST action=/api/add/person>" +
                "<h4>ID   <input type=text name=id ></h4></br>" +
                "<h4>Name <input type=text name=name required></h4></br>" +
                "<h4>Email<input type=text name=email required></h4></br>" +
                "<h4>Age  <input type=number name=age required></h4></br>" +
                "<input type=submit value=submit>" +
                "</form>";
    }

}


