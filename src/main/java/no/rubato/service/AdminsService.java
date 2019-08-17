package no.rubato.service;

import no.rubato.model.Admins;
import no.rubato.repository.AdminsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("adminsService")
public class AdminsService {
    private AdminsRepository adminsRepository;

    @Autowired
    public AdminsService(AdminsRepository adminsRepository){
        this.adminsRepository = adminsRepository;
    }
    //Search Function
    public List<Admins> findBySearchId(String searchId){
        return adminsRepository.findAll().stream().filter(
                admins -> admins.getEmail().equals(searchId) ||
                        admins.getFirstName().equals(searchId) ||
                        admins.getLastName().equals(searchId) ||
                        admins.getPhone().equals(searchId)
        ).collect(Collectors.toList());
    }

    public void saveAdmin(Admins admins){
        adminsRepository.save(admins);
    }

    public void deleteAdminsByIdAdmin(int idAdmin){
        Optional<Admins> admins = adminsRepository.findById(idAdmin);
        //adminsRepository.delete(idAdmin);
    }
}