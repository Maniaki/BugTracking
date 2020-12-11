package fr.istv.Bugtracking.route;

import fr.istv.Bugtracking.entity.Dev;
import fr.istv.Bugtracking.repository.DevRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DevRoute {

    @Autowired
    DevRepository devRepository;

   // @Autowired
    //DevService devService;

    @GetMapping("dev/id/{ID}")
    @ApiOperation(value="Retrieve one dev by its ID", response = Dev.class)
    public Dev getDev (@PathVariable("ID") int id){
        return devRepository.findById(id);
    }

    @GetMapping("dev/all")
    @ApiOperation(value="List all devs", response = List.class)
    public List<Dev> getAllDevs() {
        return devRepository.findAll();
    }

    @GetMapping("dev/lastname/{lastname}")
    @ApiOperation(value="List devs who share the same last name", response = List.class)
    public List<Dev> getByPriority(@PathVariable("priority") String lastname){
        return devRepository.findByLastname(lastname);
    }

    @GetMapping("dev/firstname/{firstname}")
    @ApiOperation(value="List devs who share the same first name", response = List.class)
    public List<Dev> getByState(@PathVariable("state") String firstname){
        return devRepository.findByFirstname(firstname);
    }
    
    @PostMapping("Dev")
    @ApiOperation(value="Create a dev", response = List.class)
    public Dev createDev(@Validated @RequestBody Dev dev) {
    	return devRepository.save(
    			dev
    			);
    }
    
    
    @DeleteMapping("dev/{id}")
    @ApiOperation(value="Delete a Dev", response = List.class)
    public ResponseEntity<?> createDev(@PathVariable("id") Integer id) throws Exception{
    	if(!devRepository.existsById(id)) {
    		throw new Exception("Bug not found with id "+ id);
    	}
    	return devRepository.findById(id)
    			.map(bug-> {
    				devRepository.delete(bug);
    				return ResponseEntity.ok().build();
    			}).orElseThrow();
    }
    
    @PutMapping("dev/update")
    @ApiOperation(value="Update First name, Last name or Avatar for target Dev", response = List.class)
    public Dev updateDev(@Validated @RequestBody Dev dev, @RequestParam int id) {
    	Dev devToUpdate = devRepository.findById(id);
    	devToUpdate.setFirstname(dev.getFirstname());
    	devToUpdate.setLastname(dev.getLastname());
    	devToUpdate.setAvatar(dev.getAvatar());
    	
    	return devRepository.save(devToUpdate);
    }
}
