package no.rubato.service;

import no.rubato.model.Admins;
import no.rubato.repository.AdminsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AdminsService")
public class AdminsService {
    private AdminsRepository adminsRepository;

    @Autowired
    public AdminsService(AdminsRepository adminsRepository){
        this.adminsRepository = adminsRepository;
    }

    public Admins findByIdAdmin(int idAdmin){
        return adminsRepository.findByIdAdmin(idAdmin);
    }
    public Admins findByFirstName(String firstName){
        return adminsRepository.findByFirstName(firstName);
    }
    public Admins findByLastName(String lastName){
        return adminsRepository.findByLastName(lastName);
    }
    public Admins findByEmail(String email){
        return adminsRepository.findByEmail(email);
    }

    public Admins findByPhone(String phone){
        return adminsRepository.findByPhone(phone);
    }

    public void saveAdmin(Admins admins){
        adminsRepository.save(admins);
    }
}