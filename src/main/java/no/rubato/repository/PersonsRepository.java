package no.rubato.repository;

import no.rubato.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonsRepository extends JpaRepository<Persons, Long> {
    Persons findByIdPerson(long idPerson);
   /* Persons findByEmail(String email);
    Persons findByToken(String token);
    Persons findByIdUser(int idUser);
    Persons findByFirstName(String firstName);
    Persons findByLastName(String lastName); */
}
