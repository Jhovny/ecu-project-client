package ecu.project.client.web.controller;


import ecu.project.client.domain.dto.Person;
import ecu.project.client.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping()
    public ResponseEntity<List<Person>> getAll() {
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getAll(@PathVariable long id) {

        return personService.getById(id)
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person){
        return  new ResponseEntity<>(this.personService.save(person), HttpStatus.OK) ;
    }


    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@RequestBody Person person,@PathVariable Long id) {

        return personService.getById(id)
                .map(x -> {
                    person.setIdPerson(x.getIdPerson());
                    return new ResponseEntity<>(personService.save(person), HttpStatus.OK) ;})
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id) {

        if (personService.delete(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
