package fr.istv.Bugtracking.repository;

import fr.istv.Bugtracking.entity.Bug;
import fr.istv.Bugtracking.entity.Dev;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

    @Repository
    public interface BugRepository extends JpaRepository<Bug, Integer>{
    	//Optional<Bug> findById(Integer id);//A completer

        Bug findById(int id);

        boolean existsById(int id);

        void deleteById(int id);

        List<Bug> findByPriority(String priority);

        List<Bug> findByState(String state);

        List<Bug> findByDev(Dev dev);

        List<Bug> findByCreationDateBetween(Date from, Date to);

    }
