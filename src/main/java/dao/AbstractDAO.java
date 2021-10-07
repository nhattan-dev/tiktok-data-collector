package dao;

import utils.HibernateUtils;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class AbstractDAO<T> {

    private final static int batchSize = 10;

    public void save(List<T> ts) {
        EntityManager em = HibernateUtils.getInstance();
        em.getTransaction().begin();
        for (int i = 0; i < ts.size(); i++) {
            em.merge(ts.get(i));
            if (i % batchSize == 0 && i != ts.size()) {
                em.flush();
                em.clear();
            }
        }
        em.getTransaction().commit();
        System.out.printf("Successfully saved %s records%n", ts.size());
    }
}
