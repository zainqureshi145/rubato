package no.rubato.controller;

import no.rubato.model.Admins;
import no.rubato.repository.AdminsRepository;
import no.rubato.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminsController {

    private int idAdmin;

    public AdminsController() {
    }


    @Autowired
    public AdminsRepository adminsRepository;//usersRepository Object
    @Autowired
    public AdminsService adminsService;//usersService Object

    @RequestMapping(value = "/allAdmins")
    public List<Admins> getAll() {
        return adminsRepository.findAll();
    }

    @RequestMapping(value = "/saveAdmin")
    public List<Admins> persist(@RequestBody final Admins admins) {
        adminsRepository.save(admins);
        return adminsRepository.findAll();
    }

    @RequestMapping(value = "/admins/{searchId}", method = RequestMethod.GET)
    public List<Admins> getBySearchId(@PathVariable String searchId) {
        return adminsService.findBySearchId(searchId);
    }
}