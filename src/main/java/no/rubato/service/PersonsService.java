package no.rubato.service;

import no.rubato.exceptions.UsernameAlreadyExistsException;
import no.rubato.model.Persons;
import no.rubato.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
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

    //Search Function
    public List<Persons> findBySearchId(String searchId) {
        return personsRepository.findAll().stream().filter(
                persons -> persons.getUsername().equals(searchId) ||
                        persons.getFirstName().equals(searchId) ||
                        persons.getLastName().equals(searchId) ||
                        persons.getCity().equals(searchId) ||
                        persons.getPhone().equals(searchId) ||
                        persons.getRole().equals(searchId)
        ).collect(Collectors.toList());
    }

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
}

