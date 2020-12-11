package fr.istv.Bugtracking.route;

import fr.istv.Bugtracking.entity.Dev;
import fr.istv.Bugtracking.repository.DevRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")//Permet à Angular d'acceder aux données
public class DevRoute {

    @Autowired
    DevRepository devRepository;

   // @Autowired
    //DevService devService;

    @GetMapping("dev/id/{id}")
    @ApiOperation(value="Retrieve one dev by its ID", response = Dev.class)
    public Dev getDev (@PathVariable("id") int id){
        return devRepository.findById(id);
    }

    @GetMapping("dev/all")
    @ApiOperation(value="List all devs", response = List.class)
    public List<Dev> getAllDevs() {
        return devRepository.findAll();
    }

    @GetMapping("dev/lastname/{lastname}")
    @ApiOperation(value="List devs who share the same last name", response = List.class)
    public List<Dev> getByPriority(@PathVariable("lastname") String lastname){
        return devRepository.findByLastName(lastname);
    }

    @GetMapping("dev/firstname/{firstname}")
    @ApiOperation(value="List devs who share the same first name", response = List.class)
    public List<Dev> getByState(@PathVariable("firstname") String firstname){
        return devRepository.findByFirstName(firstname);
    }
    
    @PostMapping("dev/create")
    @ApiOperation(value="Create a dev", response = List.class)
    public Dev createDev(@Validated @RequestBody Dev dev) {
        if ((dev.getFirstName().length() == 0) || (dev.getLastName().length() == 0)) {
            return null;//si champ invalide ne rien faire
        }
    	return devRepository.save(
    			dev
    			);
    }

    @DeleteMapping("dev/delete/{id}")
    @ApiOperation(value="Delete a Dev", response = List.class)
    public ResponseEntity<?> createDev(@PathVariable("id") Integer id) throws Exception{
    	if(!devRepository.existsById(id)) {
    		throw new Exception("Dev not found with id "+ id);
    	}
    	return devRepository.findById(id)
    			.map(bug-> {
    				devRepository.delete(bug);
    				return ResponseEntity.ok().build();
    			}).orElseThrow();
    }
    
    @PutMapping("dev/update")
    @ApiOperation(value="Update First name, Last name or Avatar for target Dev")
    public Dev updateDev(@Validated @RequestBody Dev dev, @RequestParam int id) {
    	Dev devToUpdate = devRepository.findById(id);
    	if(dev.getFirstName().length()!=0) {
            devToUpdate.setFirstName(dev.getFirstName());
        }
        if(dev.getLastName().length()!=0) {
            devToUpdate.setLastName(dev.getLastName());
        }
    	devToUpdate.setAvatar(dev.getAvatar());
    	
    	return devRepository.save(devToUpdate);
    }
}
