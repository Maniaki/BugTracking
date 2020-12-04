package fr.istv.Bugtracking.route;

import fr.istv.Bugtracking.repository.BugRepository;
import fr.istv.Bugtracking.service.XBugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BugRoute<BugService> {

    @Autowired
    BugRepository bugRepository;

    @Autowired
    XBugService bugService;

    @GetMapping("?")
    public?

}
