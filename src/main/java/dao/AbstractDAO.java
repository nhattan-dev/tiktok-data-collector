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
//                System.out.println(" Flush a batch of INSERT & release memory: {" + (i / batchSize) + "} time(s)");
                em.flush();
                em.clear();
            }
        }
//        System.out.println("Flush the last time at commit time");
        em.getTransaction().commit();
    }
}
