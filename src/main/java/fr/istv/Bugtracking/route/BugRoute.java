package fr.istv.Bugtracking.route;

import java.sql.Date;
import java.util.List;

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

import fr.istv.Bugtracking.entity.Bug;
import fr.istv.Bugtracking.repository.BugRepository;
import io.swagger.annotations.ApiOperation;

@RestController
public class BugRoute<BugService> {

    @Autowired
    BugRepository bugRepository;

  //  @Autowired
   // XBugService bugService;

    @GetMapping("bug/id/{ID}")
    @ApiOperation(value="Retrieve one bug by its ID", response = Bug.class)
        public Bug getBug (@PathVariable("ID") int id){
            return bugRepository.findById(id);
        }

    @GetMapping("bug/all")
    @ApiOperation(value="List all bugs", response = List.class)
    public List<Bug> getAllSBugs() {
        return bugRepository.findAll();
    }

    @GetMapping("bug/priority/{priority}")
    @ApiOperation(value="List bugs by a chosen priority", response = List.class)
        public List<Bug> getByPriority(@PathVariable("priority") String priority){
            return bugRepository.findByPriority(priority);
        }

    @GetMapping("bug/daterange/{creationdate}")
    @ApiOperation(value="List bugs created between two date", response = List.class)
    public List<Bug> listBugsBetweenDates(@PathVariable("from,to") Date from, Date to){
        return bugRepository.findByCreationDateBetween(from,to);
    }

    @GetMapping("bug/state/{state}")
    @ApiOperation(value="List bugs by a chosen state", response = List.class)
        public List<Bug> getByState(@PathVariable("state") String state){
            return bugRepository.findByState(state);
        }

    @GetMapping("bug/bydev/{devid}")
    @ApiOperation(value="List all bugs of a developer", response = List.class)
        public List<Bug> getBugByDev(@PathVariable("id") int devid){
            return bugRepository.findByDevId(devid);
        }
    
    @PostMapping("bug/create")
    @ApiOperation(value="Create a bug", response = List.class)
    public Bug createBug(@Validated @RequestBody Bug bug) {
    	 return bugRepository.save(
    			 bug
    			);
    }
    
    @DeleteMapping("bug/{id}")
    @ApiOperation(value="Delete a bug", response = List.class)
    public ResponseEntity<?> createBug(@PathVariable("id") Integer id) throws Exception{
    	if(!bugRepository.existsById(id)) {
    		throw new Exception("Bug not found with id "+ id);
    	}
    	return bugRepository.findById(id)
    			.map(bug-> {
    				bugRepository.delete(bug);
    				return ResponseEntity.ok().build();
    			}).orElseThrow();
    }
    
    @PutMapping("bug/update")
    @ApiOperation(value="Update description,priority,state or DevId for target Bug", response = List.class)
    public Bug updateBug(@Validated @RequestBody Bug bug, @RequestParam int id) {
    	Bug bugToUpdate = bugRepository.findById(id);
    	bugToUpdate.setDescription(bug.getDescription());
    	bugToUpdate.setPriority(bug.getPriority());
    	bugToUpdate.setState(bug.getState());
    	bugToUpdate.setDevId(bug.getDevId());
    	
    	return bugRepository.save(bugToUpdate);
    }
}
