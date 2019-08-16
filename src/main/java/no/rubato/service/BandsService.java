package no.rubato.service;

import no.rubato.model.Bands;
import no.rubato.repository.BandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bandsService")
public class BandsService {
    private BandsRepository bandsRepository;

    @Autowired
    public BandsService(BandsRepository bandsRepository){
        this.bandsRepository = bandsRepository;
    }

    public Bands findByIdBand(int idBand){
        return bandsRepository.findByIdBand(idBand);
    }
    public Bands findByBandName(String bandName){
        return bandsRepository.findByBandName(bandName);
    }
    public Bands findByEmail(String email){
        return bandsRepository.findByEmail(email);
    }
    public Bands findByPhone(String phone){
        return bandsRepository.findByPhone(phone);
    }
    public Bands findByCity(String city){
        return bandsRepository.findByCity(city);
    }
    public Bands findByGenre(String genre){
        return bandsRepository.findByGenre(genre);
    }
    public void saveBand(Bands bands){
        bandsRepository.save(bands);
    }
}
