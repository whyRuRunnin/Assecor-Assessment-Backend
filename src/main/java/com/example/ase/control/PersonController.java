package com.example.ase.control;

import com.example.ase.person.Person;
import com.example.ase.modell.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class PersonController implements ErrorController {
    private static final String PATH ="/error";
    @RequestMapping(value = PATH)
    public String error() {
        return "Error handling";
    }
    public String getErrorPath() {
        return PATH;
    }
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @GetMapping (value = "/persons")
    public List<Person> getAllPeople() {
        personService.readCSV();
        return personService.getAllPeople();
    }
    @GetMapping (value = "/persons/{id}")
    public List<Person> getPersonById(@PathVariable Integer id) {
       return personService.getPersonById(id);
    }
    @GetMapping(value = "/persons/colors/{color}")
    public @ResponseBody List<Person> getPersonByColor(@PathVariable(value = "color") String color) {
        return personService.getPersonByColor(color);
    }
    @PostMapping(value ="/persons")
    public void createPerson(@RequestBody Person person) {
        personService.createPerson(person);
    }
    @DeleteMapping(value ="/persons/{id}")
    public void deletePersonById(@PathVariable ("id") Integer id) {
        personService.deletePerson(id);
    }
    @PutMapping(value = "/persons/{id}")
    public void updatePerson(@RequestBody Person person, @PathVariable Integer id) {
        personService.updatePerson(id, person);
    }
}
