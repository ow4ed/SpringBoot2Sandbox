package com.example.demo.com.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.com.dao.PersonDao;
import com.example.demo.com.model.Person;

@Service
public class PersonService {

    @Autowired// inject!
    @Qualifier("postgres")
    private final PersonDao personDao;
    
    // use qualifier to distinguish multiple interface implementations
    public PersonService(@Qualifier("postgres") PersonDao personDao) {
        this.personDao = personDao;
    }
    
    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }
    
    public List<Person> getAllPoeple() {
        return personDao.selectAllPeople();
    }
  
    public Optional<Person> getPersonById(UUID id) {
        return personDao.selectPersonById(id);
    }
    
    public int deletePerson(UUID id) {
        return personDao.deletePersonById(id);
    }
    
    public int updatePerson(UUID id, Person person) {
        return personDao.updatePersonById(id, person);
    }

}