package no.rubato.repository;

import no.rubato.model.Bands;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandsRepository extends JpaRepository<Bands, Long> {
    Bands getByIdBand(long idBand);
    Bands findByUsername(String username);
}
