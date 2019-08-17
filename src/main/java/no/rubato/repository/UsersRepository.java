package no.rubato.repository;

import no.rubato.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {}
