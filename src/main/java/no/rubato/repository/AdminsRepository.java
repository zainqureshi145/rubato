package no.rubato.repository;

import no.rubato.model.Admins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminsRepository extends JpaRepository<Admins, Integer> {
    /*Admins findByEmail(String email);
    Admins findByPhone(String phone);
    Admins findByIdAdmin(int idAdmin);
    Admins findByFirstName(String firstName);
    Admins findByLastName(String lastName);*/
    Admins deleteAdminsByIdAdmin(int idAdmin);
}
