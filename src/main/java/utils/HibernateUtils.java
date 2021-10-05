package utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtils {

    private static EntityManager em;

    private HibernateUtils() {
    }

    public static EntityManager getInstance() {
        if (em == null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
            em = entityManagerFactory.createEntityManager();
        }
        return em;
    }
}
