package com.example.demo.com.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.com.model.Person;
import com.example.demo.com.service.PersonService;

@RequestMapping("api/v1/person")
@RestController// rest web service
public class PersonController {

    private final PersonService personService;
    
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    
    @PostMapping// will be http post 
    public void addPerson(@Valid @NotNull @RequestBody Person person) {
        personService.addPerson(person);
    }
    
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPoeple();
    }
    
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return personService.getPersonById(id).orElse(null);
    }
    
    @DeleteMapping(path = "{id}")
    public void deletePerson(@PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }
    
    @PutMapping(path = "{id}")
    // @Valid comes from Javax, and will enforce the @NotBlack fields declared inside Person Object, for instance
    public void updatePerson(@PathVariable("id") UUID id,@Valid @NotNull @RequestBody Person personToUpdate) {
        personService.updatePerson(id, personToUpdate);
    }
    
}
