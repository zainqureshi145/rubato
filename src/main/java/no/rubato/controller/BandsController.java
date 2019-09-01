package no.rubato.controller;
import no.rubato.model.Bands;
import no.rubato.service.BandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
//@RequestMapping("/api2/band")
public class BandsController {
    public BandsController() {
    }

    //@Autowired
    //public PersonsRepository personsRepository;//personsRepository Object
    @Autowired
    public BandsService bandsService;//personsService Object

    @GetMapping("/all")//Show all Users from Database
    public ResponseEntity<?> getAll(){
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        return new ResponseEntity<>(bandsService.getAll(), HttpStatus.OK);
    }
}