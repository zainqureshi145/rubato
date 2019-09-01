package no.rubato.service;

import no.rubato.model.Bands;
import no.rubato.repository.BandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomBandDetailsService implements UserDetailsService {

    @Autowired
    private BandsRepository bandsRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Bands bands = bandsRepository.findByUsername(username);
        if(bands == null) new UsernameNotFoundException("User not found");
        return (UserDetails) bands;
    }
    @Transactional
    public Bands loadBandById(long idBand){
        Bands bands = bandsRepository.getByIdBand(idBand);
        if(bands == null) new UsernameNotFoundException("User not found");
        return bands;
    }
}
