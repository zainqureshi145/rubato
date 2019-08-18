package no.rubato.service;

import no.rubato.model.Persons;
import no.rubato.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("personsService")
public class PersonsService {
    private PersonsRepository personsRepository;

    @Autowired
    public PersonsService(PersonsRepository personsRepository){
        this.personsRepository = personsRepository;
    }
    //Search Function
    public List<Persons> findBySearchId(String searchId){
        return personsRepository.findAll().stream().filter(
                persons -> persons.getEmail().equals(searchId) ||
                        persons.getFirstName().equals(searchId) ||
                        persons.getLastName().equals(searchId) ||
                        persons.getCity().equals(searchId) ||
                        persons.getPhone().equals(searchId) ||
                        persons.getIsAdmin().equals(searchId)
        ).collect(Collectors.toList());
    }

    public Persons findByIdPerson(long idPerson){
        return personsRepository.findByIdPerson(idPerson);
    }

    public void savePerson(Persons persons){
        personsRepository.save(persons);
    }
}

   /*
    public Persons findByFirstName(String firstName){
        return personsRepository.findByFirstName(firstName);
    }
    public Persons findByLastName(String lastName){
        return personsRepository.findByLastName(lastName);
    }
    public Persons findByEmail(String email){
        return personsRepository.findByEmail(email);
    }
    public Persons findByToken(String token){
        return personsRepository.findByToken(token);
    }*/


