package com.example.ase.modell;

import com.example.ase.person.Person;
import com.example.ase.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonsRepository personsRepository;
    public void readCSV() {
        String path = "/Users/robertpopescu/foaie.csv";
        String line = "";
        BufferedReader br;
        List<Person> persons = new ArrayList<>();

        {
            try {
                br = new BufferedReader(new FileReader(path));
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(",");
                    Person person = new Person();
                    person.setName(values[0]);
                    person.setLastname(values[1]);
                    String[] address = values[2].split(" ");
                    person.setZipcode(Integer.valueOf(address[1]));
                    person.setCity(address[2]);
                    switch (values[3].charAt(1)) {
                        case '1':
                            person.setColor("blau");
                            break;
                        case '2':
                            person.setColor("grün");
                            break;
                        case '3':
                            person.setColor("violett");
                            break;
                        case '4':
                            person.setColor("rot");
                            break;
                        case '5':
                            person.setColor("gelb");
                            break;
                        case '6':
                            person.setColor("türkis");
                            break;
                        case '7':
                            person.setColor("weiß");
                            break;
                    }
                    persons.add(person);
                    personsRepository.save(person);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public List<Person> getAllPeople() {
        List<Person> people = new ArrayList<>();
        personsRepository.findAll().forEach(people::add);
        return people;
    }
    public List<Person> getPersonById(Integer id) {
        return getAllPeople().stream().filter(y -> y.getId() == id).collect(Collectors.toList());
    }

    public List<Person> getPersonByColor(String color) {
        return getAllPeople().stream().filter(y -> y.getColor().equals(color)).collect(Collectors.toList());
    }
    public void createPerson(Person person) {
        personsRepository.save(person);
    }
    public void updatePerson(Integer id, Person person){
        personsRepository.save(person);
    }
    public void deletePerson(Integer id) {
        Person person = getAllPeople().stream().filter(y -> y.getId() == id).findFirst().get();
        personsRepository.delete(person);
    }
}