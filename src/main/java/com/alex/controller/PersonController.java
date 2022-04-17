package com.alex.controller;

import com.alex.model.Person;
import com.alex.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService service;

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Person person) {
        Person savedPerson = service.save(person);

        return new ResponseEntity<>(savedPerson, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        Person foundPerson = service.findById(id);

        return new ResponseEntity<>(foundPerson, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        List<Person> persons = service.findAll();

        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Person person) throws Exception {
        Person updatedPerson = service.update(person);

        return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable long id) throws Exception {
        service.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
