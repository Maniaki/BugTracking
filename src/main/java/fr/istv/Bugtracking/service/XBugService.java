package fr.istv.Bugtracking.service;

import fr.istv.Bugtracking.entity.Bug;
import fr.istv.Bugtracking.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class XBugService { //XBugService avec le X car BugService est déjà une classe existant derivant de
    // la classe Object

    @Autowired
    private BugRepository bugRepository;

    public Bug findBugById(int id) { return bugRepository.findById(id);}

    public Bug saveBug(Bug bug){
        return bugRepository.save(bug);
    }

    public Bug updateBug(Bug bug){
        return bugRepository.save(bug);
    }

    public void deleteBug(int id){ bugRepository.deleteById(id); }

    public boolean checkIfIdExists(Integer id) {
        return bugRepository.existsById(id);
    }

    public List<Bug> getBugsByPriority(String priority) {
        return bugRepository.findByPriority(priority);
    }

    public List<Bug> getBugsByState(String state) {
        return bugRepository.findByState(state);
    }

    public List<Bug> getBugsByDevId(int devid) {
        return bugRepository.findByDevId(devid);
    }

    public List<Bug> getBugsByDev(Date from, Date to) {
        return bugRepository.findByCreationDateBetween(from,to);
    }

}
