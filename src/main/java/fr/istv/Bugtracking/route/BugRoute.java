package fr.istv.Bugtracking.route;

import fr.istv.Bugtracking.entity.Bug;
import fr.istv.Bugtracking.repository.BugRepository;
import fr.istv.Bugtracking.service.XBugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BugRoute<BugService> {

    @Autowired
    BugRepository bugRepository;

    @Autowired
    XBugService bugService;

    @GetMapping("bug/{ID}") 
        public Bug getBug (@PathVariable("ID") int id){
            return bugRepository.findById(id);
        }
    

    @GetMapping("bug")
    public List<Bug> getAllSBugs() {
        return bugRepository.findAll();
    }

    @GetMapping("bug/{priority}")
        public List<Bug> getByPriority(@PathVariable("priority") String priority){
            return bugRepository.findByPriority(priority);
        }
    

    @GetMapping("bug/{priority}")
        public List<Bug> getByState(@PathVariable("state") String state){
            return bugRepository.findByState(state);
        }
}

