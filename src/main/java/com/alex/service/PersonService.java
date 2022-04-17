package com.alex.service;

import com.alex.model.Person;
import com.alex.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public Person save(Person person) {
        return repository.save(person);
    }

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findById(long id) {
        return repository.findById(id).get();
    }

    public Person update(Person person) throws Exception {

        Person foundPerson = repository.findById(person.getId()).orElseThrow(() -> new Exception("nu e bine"));

        return repository.save(person);

    }

    public void delete(long id) throws Exception {
        Person person= repository.findById(id).orElseThrow(()->new Exception("not found"));
        repository.delete(person);
    }
}
