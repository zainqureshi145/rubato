package no.rubato.controller;

import no.rubato.model.Users;
import no.rubato.repository.UsersRepository;
import no.rubato.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class rubatoController {
    public rubatoController() {
    }

    @RequestMapping(value = "/helloWorld")
    public String hello(){//This is running if i go to localhost:8080/booking
        return "Hello World from Rubato.no";
    }

   /* @Autowired
    public UsersRepository usersRepository;
    @Autowired
    public UsersService usersService;

    @RequestMapping(value = "/allUsers")
    public List<Users> getAll(){
        return usersRepository.findAll();
    }
    @RequestMapping(value = "/save")
    public List<Users> persist(@RequestBody final Users users){
        usersRepository.save(users);
        return usersRepository.findAll();
    }
    @GetMapping("/users/{idUser}")
    public ResponseEntity<?> getUserById(@PathVariable int idUser){
        Users users = usersService.findByIdUser(idUser);
        return new ResponseEntity<Users>(users, HttpStatus.OK);
    }*/
}
