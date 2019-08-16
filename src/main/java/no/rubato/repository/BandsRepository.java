package no.rubato.repository;

import no.rubato.model.Bands;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BandsRepository extends JpaRepository<Bands, Integer> {
    Bands findByEmail(String email);
    Bands findByIdBand(int idBand);
    Bands findByBandName(String bandName);
    Bands findByPhone(String phone);
    Bands findByCity(String city);
    Bands findByGenre(String genre);
}
