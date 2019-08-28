package no.rubato.controller;
import no.rubato.service.PersonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/persons")
public class PersonsController {
    public PersonsController() {
    }

    //@Autowired
    //public PersonsRepository personsRepository;//personsRepository Object
    @Autowired
    public PersonsService personsService;//personsService Object

    @GetMapping("/all")//Show all Users from Database
    public ResponseEntity<?> getAll(){
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        return new ResponseEntity<>(personsService.getAll(), HttpStatus.OK);
    }
}