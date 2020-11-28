package fr.istv.Bugtracking.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.istv.Bugtracking.model.Bug;

    @Repository
    public interface BugRepository extends JpaRepository<Bug, Integer>{
    	Optional<Bug> findById(Integer id);//A completer
    }
