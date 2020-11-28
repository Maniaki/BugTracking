package fr.istv.Bugtracking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.istv.Bugtracking.Model.Dev;

@Repository
    public interface DevRepository extends JpaRepository<Dev,Integer>{
    	Optional<Dev> findById(Integer Id);
    }
    	//A completer
