package no.rubato.repository;

import no.rubato.model.Persons;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonsRepository extends JpaRepository<Persons, Long> {
    Persons findByIdPerson(long idPerson);
    Persons getByIdPerson(long idPerson);
    Persons findByUsername(String username);
    Persons findByFirstName(String firstName);
    Persons findByLastName(String lastName);
    Persons findByRole(String role);
}
