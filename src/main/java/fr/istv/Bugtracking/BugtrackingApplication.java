package fr.istv.Bugtracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

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

	public static void main(String[] args) {
		SpringApplication.run(BugtrackingApplication.class, args);
	}

}
