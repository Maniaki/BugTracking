package fr.istv.Bugtracking.service;

import fr.istv.Bugtracking.entity.Dev;
import fr.istv.Bugtracking.repository.DevRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevService {

    @Autowired
    DevRepository devRepository;

    public Dev findById(int id){
        return devRepository.findById(id);
    }

    public void delete(int id){
        devRepository.deleteById(id);
    }

    public List<Dev> getDevsByFirstName(String firstname){
        return devRepository.findByFirstName(firstname);
    }

    public List<Dev> getDevsByLastName(String lastname){
        return devRepository.findByLastName(lastname);
    }

   /** public Dev updateAvatar(String url){
        return devRepository.updateAvatar(url);
    }**/

}
