package fr.istv.Bugtracking;

import fr.istv.Bugtracking.Model.Dev;
import fr.istv.Bugtracking.Model.Bug;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

@SpringBootApplication
public class BugtrackingApplication {

	private static EntityManager em = null;

	static {
		try {
			em = Persistence.createEntityManagerFactory("BugTrackingService").createEntityManager();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public Dev CreateDev() {
		Dev dev = new Dev();
		em.persist(dev);
		return dev;
	}

	public Dev FindDev(int id) {
		return em.find(Dev.class, id);
	}
	
	public Collection<Dev> FindAllDev(){
		Query query = em.createQuery("SELECT s FROM Dev s");
		return (Collection<Dev>) query.getResultList();
	}
	
	public void RemoveDev(int id) {
		Dev d = FindDev(id);
		if(d != null) {
			em.remove(d);
		}
	}
	
	public Bug CreateBug() {
		Bug b = new Bug();
		em.persist(b);
		return b;
	}
	
	public Bug FindBug(int id) {
		return em.find(Bug.class, id);
	}
	
	public Collection<Bug> FindAllBug(){
		Query query = em.createQuery("SELECT l FROM Bug l");
		return (Collection<Bug>) query.getResultList();
	}
	
	public void RemoveBug(int id) {
		Bug b = FindBug(id);
		if(b != null) {
			em.remove(b);
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BugtrackingApplication.class, args);
	}

}
