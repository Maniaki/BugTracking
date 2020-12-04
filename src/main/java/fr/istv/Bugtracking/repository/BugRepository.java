package fr.istv.Bugtracking.repository;

import java.util.Date;
import java.util.List;

import fr.istv.Bugtracking.entity.Dev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.istv.Bugtracking.entity.Bug;

    @Repository
    public interface BugRepository extends JpaRepository<Bug, Integer>{
    	//Optional<Bug> findById(Integer id);//A completer

        Bug findById(int id);

        List<Bug> findByPriority(String first_name);

        List<Bug> findByState(String last_name);

        List<Bug> findByDev(Dev dev);

        List<Bug> findByDateBetween(Date from, Date to);
    }
