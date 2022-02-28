package com.example.ase.repository;

import com.example.ase.person.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource
public interface PersonsRepository extends CrudRepository<Person, Integer> {

}
