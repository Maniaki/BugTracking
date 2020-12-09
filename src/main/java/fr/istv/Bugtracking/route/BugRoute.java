package fr.istv.Bugtracking.route;

import fr.istv.Bugtracking.entity.Bug;
import fr.istv.Bugtracking.repository.BugRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
public class BugRoute<BugService> {

    @Autowired
    BugRepository bugRepository;

  //  @Autowired
   // XBugService bugService;

    @GetMapping("bug/{ID}")
    @ApiOperation(value="Retrieve one bug by its ID", response = Bug.class)
        public Bug getBug (@PathVariable("ID") int id){
            return bugRepository.findById(id);
        }

    @GetMapping("bug")
    @ApiOperation(value="List all bugs", response = List.class)
    public List<Bug> getAllSBugs() {
        return bugRepository.findAll();
    }

    @GetMapping("bug/{priority}")
    @ApiOperation(value="List bugs by a chosen priority", response = List.class)
        public List<Bug> getByPriority(@PathVariable("priority") String priority){
            return bugRepository.findByPriority(priority);
        }

    @GetMapping("bug/{creationdate}")
    @ApiOperation(value="List bugs created between two date", response = List.class)
    public List<Bug> listBugsBetweenDates(@PathVariable("from,to") Date from, Date to){
        return bugRepository.findByCreationDateBetween(from,to);
    }

    @GetMapping("bug/{state}")
    @ApiOperation(value="List bugs by a chosen state", response = List.class)
        public List<Bug> getByState(@PathVariable("state") String state){
            return bugRepository.findByState(state);
        }

    @GetMapping("bug/{devid}")
    @ApiOperation(value="List all bugs of a developer", response = List.class)
        public List<Bug> getBugByDev(@PathVariable("id") int devid){
            return bugRepository.findByDevId(devid);
        }
}
