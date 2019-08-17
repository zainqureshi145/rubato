package no.rubato.controller;

import no.rubato.model.Users;
import no.rubato.repository.UsersRepository;
import no.rubato.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    private int idUser;

    public UsersController() {
    }


    @Autowired
    public UsersRepository usersRepository;//usersRepository Object
    @Autowired
    public UsersService usersService;//usersService Object

    @RequestMapping(value = "/allUsers")
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    @RequestMapping(value = "/save")
    public List<Users> persist(@RequestBody final Users users) {
        usersRepository.save(users);
        return usersRepository.findAll();
    }

    @RequestMapping(value = "/users/{searchId}", method = RequestMethod.GET)
    public List<Users> getBySearchId(@PathVariable String searchId) {
        return usersService.findBySearchId(searchId);
    }
}
   /* @GetMapping("/users/id/{idUser}")
    public ResponseEntity<?> getUserById(@PathVariable int idUser){
        Users users = usersService.findByIdUser(idUser);
        return new ResponseEntity<Users>(users, HttpStatus.OK);
    }
    @RequestMapping(value = "/users/email/{email}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByEmail(@PathVariable String email){
        Users users = usersService.findByEmail(email);
        return new ResponseEntity<Users>(users, HttpStatus.OK);
    }
    @RequestMapping(value = "/users/firstName/{firstName}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByFirstName(@PathVariable String firstName){
        Users users = usersService.findByFirstName(firstName);
        return new ResponseEntity<Users>(users, HttpStatus.OK);
    }
    @RequestMapping(value = "/users/lastName/{lastName}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserByLastName(@PathVariable String lastName){
        Users users = usersService.findByLastName(lastName);
        return new ResponseEntity<Users>(users, HttpStatus.OK);
    }

  @RequestMapping(value = "/users/{searchId}", method = RequestMethod.GET)
    public ResponseEntity<?> getUserBySearchId(@PathVariable String searchId){
       Users users = (Users) usersService.findBySearchId(searchId);
       return new ResponseEntity<Users>(users, HttpStatus.OK);
   }
   @RequestMapping(value = "/{searchId}", method = RequestMethod.GET)
    public List<Users> getAll(@PathVariable String searchId){
        return usersRepository.findAll().stream().filter(
                users -> users.getEmail().equals(searchId) ||
                         users.getFirstName().equals(searchId) ||
                         users.getLastName().equals(searchId) ||
                         users.getCity().equals(searchId)
        ).collect(Collectors.toList());
    }*/
