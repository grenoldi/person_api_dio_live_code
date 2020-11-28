package com.digitalinnovationone.personapi.controller;


import com.digitalinnovationone.personapi.dto.response.MessageResponseDTO;
import com.digitalinnovationone.personapi.entity.Person;
import com.digitalinnovationone.personapi.repository.PersonRepository;
import com.digitalinnovationone.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController{

    private PersonService personService;

    @Autowired
    public PersonController(PersonService ps){
        this.personService = ps;
    }

    @PostMapping
    //request body is an annotation to inform person is result of a requisition
    public MessageResponseDTO createPerson(@RequestBody Person person){
        return personService.createPerson(person);
    }
}
