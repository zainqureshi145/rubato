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
  public UsersService(UsersRepository usersRepository) {
    this.usersRepository = usersRepository;
  }

  public Users saveUser(Users users) {
      // add logic to do some validation before creating user object
    return usersRepository.save(users);
  }

  public List<Users> searchUser(String search) {
    return usersRepository.findAll().stream()
        .filter(
            user ->
                user.getEmail().equals(search)
                    || user.getFirstName().equals(search)
                    || user.getLastName().equals(search))
        .collect(Collectors.toList());
  }

  public List<Users> getAllUsers() { return usersRepository.findAll(); }
}
