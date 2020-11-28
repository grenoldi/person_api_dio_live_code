package com.digitalinnovationone.personapi.service;

import com.digitalinnovationone.personapi.dto.response.MessageResponseDTO;
import com.digitalinnovationone.personapi.entity.Person;
import com.digitalinnovationone.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository pr){
        this.personRepository = pr;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    //request body is an annotation to inform person is result of a requisition
    public MessageResponseDTO createPerson(Person person){

        Person savedPerson = personRepository.save(person);

        return MessageResponseDTO.builder().message("Created person with ID " + savedPerson.getId()).build();

    }
}
