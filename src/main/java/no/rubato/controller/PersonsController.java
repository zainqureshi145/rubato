package no.rubato.controller;

import no.rubato.model.Persons;
import no.rubato.repository.PersonsRepository;
import no.rubato.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonsController {
    public PersonsController() {
    }
    @Autowired
    public PersonsRepository personsRepository;//personsRepository Object
    @Autowired
    public PersonsService personsService;//personsService Object
////Creation
    @RequestMapping(value = "/persons/save")
    public List<Persons> persist(@RequestBody final Persons persons) {
        personsRepository.save(persons);
        return personsRepository.findAll();
    }
////Searching
    @RequestMapping(value = "/persons/{searchId}", method = RequestMethod.GET)
    public List<Persons> getBySearchId(@PathVariable String searchId) {
        return personsService.findBySearchId(searchId);
    }
////Search By ID
    @RequestMapping(value = "/persons/id/{idPerson}")
    public ResponseEntity<?> getById(@PathVariable int idPerson){
        Persons persons = personsService.findByIdPerson(idPerson);
        return new ResponseEntity<Persons>(persons, HttpStatus.OK);
    }
////Delete By ID
    @RequestMapping(value = "/persons/delete/{idPerson}")
    public void deletePerson(@PathVariable long idPerson){
        personsRepository.deleteById(idPerson);
    }
////Show All
    @RequestMapping(value = "/persons/showAll")
    public List<Persons> getAll() {
        return personsRepository.findAll();
    }
}