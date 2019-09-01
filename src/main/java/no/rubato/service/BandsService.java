package no.rubato.service;

import no.rubato.exceptions.UsernameAlreadyExistsException;
import no.rubato.model.Bands;
import no.rubato.repository.BandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("bandsService")
public class BandsService {

    @Autowired
    private BandsRepository bandsRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public BandsService(BandsRepository bandsRepository) {
        this.bandsRepository = bandsRepository;
    }

    //Search Function
    public List<Bands> findBySearchId(String searchId) {
        return bandsRepository.findAll().stream().filter(
                bands -> bands.getUsername().equals(searchId) ||
                        bands.getPhone().equals(searchId)
        ).collect(Collectors.toList());
    }

    public Bands saveBand(Bands bands) {
        try {
            bands.setPassword(bCryptPasswordEncoder.encode(bands.getPassword()));
            //username (email) has to be unique (throws exception)
            bands.setUsername(bands.getUsername());
            bands.setConfirmPassword("");
            //password and confirmPassword should match
            //do not persist or show confirmPassword
            return bandsRepository.save(bands);
        } catch (Exception e) {
            throw new UsernameAlreadyExistsException("Username '" + bands.getUsername() + "' already exists");
        }
    }

    public List<Bands> getAll(){
        return bandsRepository.findAll();
    }

}

