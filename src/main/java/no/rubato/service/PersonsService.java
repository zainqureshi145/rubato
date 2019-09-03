package no.rubato.service;

import no.rubato.exceptions.UsernameAlreadyExistsException;
import no.rubato.model.Persons;
import no.rubato.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("personsService")
public class PersonsService {

    @Autowired
    private PersonsRepository personsRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public PersonsService(PersonsRepository personsRepository) {
        this.personsRepository = personsRepository;
    }

    //Search Function Unused For Now
    public List<Persons> findBySearchId(String searchId) {
        return personsRepository.findAll().stream().filter(
                persons -> persons.getUsername().equals(searchId) ||
                        persons.getPhone().equals(searchId) ||
                        persons.getRole().equals(searchId)
        ).collect(Collectors.toList());
    }
    //Find By id
    public Persons findBySearchId(long id){
        return personsRepository.getByIdPerson(id);
    }
    //Save
    public Persons savePerson(Persons persons) {
        try {
            persons.setPassword(bCryptPasswordEncoder.encode(persons.getPassword()));
            //username (email) has to be unique (throws exception)
            persons.setUsername(persons.getUsername());
            persons.setConfirmPassword("");
            //password and confirmPassword should match
            //do not persist or show confirmPassword
            return personsRepository.save(persons);
        } catch (Exception e) {
            throw new UsernameAlreadyExistsException("Username '" + persons.getUsername() + "' already exists");
        }
    }
    //Update
    public void updatePerson(Persons persons){
        persons.setPassword(bCryptPasswordEncoder.encode(persons.getPassword()));
        personsRepository.save(persons);
    }
    //List All Users for Admin Dashboard
    public List<Persons> getAll(){
        return personsRepository.findAll();
    }
    //Delete
    public void deletePersonById(long id){
        personsRepository.deleteById(id);
    }
}

