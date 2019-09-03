package no.rubato.controller;
import no.rubato.model.Persons;
import no.rubato.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {

    private final PersonsService personsService;

    @Autowired
    public UserController(PersonsService personsService) {
        this.personsService = personsService;
    }
    ///Update Profile Information
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateInfo(@PathVariable("id") long id, @RequestBody Persons persons){
        Persons currentPerson = personsService.findBySearchId(id);
        if(currentPerson == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentPerson.setUsername(persons.getUsername());
        currentPerson.setName(persons.getName());
        currentPerson.setPassword(persons.getPassword());
        currentPerson.setConfirmPassword(persons.getConfirmPassword());
        currentPerson.setPhone(persons.getPhone());

        personsService.updatePerson(currentPerson);
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }
    ///Delete Profile
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id, Persons persons){
        Persons currentPerson = personsService.findBySearchId(id);
        if(currentPerson == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        personsService.deletePersonById(id);
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    ///More Complex Booking Request Mapping

    ///Cancel Booking Request Mapping
}