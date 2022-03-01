package com.example.ase.repository;

import com.example.ase.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource
public interface PersonsRepository extends JpaRepository<Person, Integer> {

    List<Person> findAllByColor(String color);
}
