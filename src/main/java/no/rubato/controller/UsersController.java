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
@RequestMapping("/api/users")
public class UsersController {
    public UsersController(UsersService usersService){
        this.usersService = usersService;
    }

    private UsersService usersService;//usersService Object

    @GetMapping(value = "/allUsers")
    public ResponseEntity<List<Users>> getAll() {
        return new ResponseEntity<>(usersService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Users> createUser(@RequestBody Users users){
        Users user = usersService.saveUser(users);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/search/{searchId}")
    public ResponseEntity<?> searchUser(@PathVariable String searchId){
        List<Users> users = usersService.searchUser(searchId);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
