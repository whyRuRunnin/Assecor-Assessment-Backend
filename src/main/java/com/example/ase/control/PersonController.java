package com.example.ase.control;

import com.example.ase.person.Person;
import com.example.ase.modell.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
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
    @RequestMapping (value = "/persons", method = GET)
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }
    @RequestMapping (value = "/persons/{id}", method = RequestMethod.GET)
    public List<Person> getPersonById(@PathVariable Integer id) {
       return personService.getPersonById(id);
    }
    @RequestMapping(value = "/persons/colors/{color}", method = RequestMethod.GET)
    public @ResponseBody List<Person> getPersonByColor(@PathVariable(value = "color") String color) {
        return personService.getPersonByColor(color);
    }
    @RequestMapping(method = RequestMethod.POST, value ="/persons")
    public void createPerson(@RequestBody Person person) {
        personService.createPerson(person);
    }
    @RequestMapping(method = RequestMethod.DELETE, value ="/persons/{id}")
    public void deletePersonById(@PathVariable ("id") Integer id) {
        personService.deletePerson(id);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/persons/{id}")
    public void updatePerson(@RequestBody Person person, @PathVariable Integer id) {
        personService.updatePerson(id, person);
    }
}
