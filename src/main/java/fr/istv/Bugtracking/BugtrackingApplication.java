package fr.istv.Bugtracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Model.Bug;
import Model.Dev;

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
	
	public Dev createdev() {
		Dev dev = new Dev();
		em.persist(dev);
		return dev;
	}

	public Dev finddev(int id) {
		return em.find(Dev.class, id);
	}
	
	public Collection<Dev> findAllDev(){
		Query query = em.createQuery("SELECT s FROM Dev s");
		return (Collection<Dev>) query.getResultList();
	}
	
	public void removeDev(int id) {
		Dev d = finddev(id);
		if(d != null) {
			em.remove(d);
		}
	}
	
	public Bug createbug() {
		Bug b = new Bug();
		em.persist(b);
		return b;
	}
	
	public Bug findbug(int id) {
		return em.find(Bug.class, id);
	}
	
	public Collection<Bug> findallBug(){
		Query query = em.createQuery("SELECT l FROM Bug l");
		return (Collection<Bug>) query.getResultList();
	}
	
	public void removeBug(int id) {
		Bug b = findbug(id);
		if(b != null) {
			em.remove(b);
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BugtrackingApplication.class, args);
	}

}
