package no.rubato.service;

import no.rubato.model.Users;
import no.rubato.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("usersService")
public class UsersService {
    private UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }
    //Search Function
    public List<Users> findBySearchId(String searchId){
        return usersRepository.findAll().stream().filter(
                users -> users.getEmail().equals(searchId) ||
                        users.getFirstName().equals(searchId) ||
                        users.getLastName().equals(searchId) ||
                        users.getCity().equals(searchId)
        ).collect(Collectors.toList());
    }

    public void saveUser(Users users){
        usersRepository.save(users);
    }
}

   /* public Users findByIdUser(int idUser){
        return usersRepository.findByIdUser(idUser);
    }
    public Users findByFirstName(String firstName){
        return usersRepository.findByFirstName(firstName);
    }
    public Users findByLastName(String lastName){
        return usersRepository.findByLastName(lastName);
    }
    public Users findByEmail(String email){
        return usersRepository.findByEmail(email);
    }
    public Users findByToken(String token){
        return usersRepository.findByToken(token);
    }*/


