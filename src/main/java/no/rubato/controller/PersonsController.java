package no.rubato.controller;

import no.rubato.model.Persons;
import no.rubato.repository.PersonsRepository;
import no.rubato.service.MapValidationErrorService;
import no.rubato.service.PersonsService;
import no.rubato.validator.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonsController {
    public PersonsController() {
    }
    @Autowired
    public PersonsRepository personsRepository;//personsRepository Object
    @Autowired
    public PersonsService personsService;//personsService Object
    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private PersonValidator personValidator;

////Register Person
    @PostMapping("/register")
    public ResponseEntity<?> registerPerson(@Valid @RequestBody Persons persons, BindingResult result){
        //Validate passwords match
        personValidator.validate(persons, result);

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap != null) return errorMap;
        Persons newPerson = personsService.savePerson(persons);
        //personsService.savePerson(persons);
        return new ResponseEntity<Persons>(newPerson, HttpStatus.CREATED);
        //return new ResponseEntity<Persons>(persons, HttpStatus.CREATED);
    }

    /*
////Creation
    @RequestMapping(value = "/save")
    public List<Persons> persist(@RequestBody final Persons persons) {
        personsRepository.save(persons);
        return personsRepository.findAll();
    }
////Searching
    @RequestMapping(value = "/{searchId}", method = RequestMethod.GET)
    public List<Persons> getBySearchId(@PathVariable String searchId) {
        return personsService.findBySearchId(searchId);
    }
////Search By ID
    @RequestMapping(value = "/id/{idPerson}")
    public ResponseEntity<?> getById(@PathVariable int idPerson){
        Persons persons = personsService.findByIdPerson(idPerson);
        return new ResponseEntity<Persons>(persons, HttpStatus.OK);
    }
////Delete By ID
    @RequestMapping(value = "/delete/{idPerson}")
    public void deletePerson(@PathVariable long idPerson){
        personsRepository.deleteById(idPerson);
    }
////Show All
    @RequestMapping(value = "/showAll")
    public List<Persons> getAll() {
        return personsRepository.findAll();
    }

     */
}