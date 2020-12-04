package fr.istv.Bugtracking.route;

import fr.istv.Bugtracking.repository.DevRepository;
import fr.istv.Bugtracking.service.DevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevRoute {

    @Autowired
    DevRepository devRepository;

    @Autowired
    DevService devService;
}
