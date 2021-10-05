package dao.impl;

import dao.DAO;
import entity.Ad;
import utils.HibernateUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class AdDAO implements DAO<Ad> {
    private static AdDAO dao;

    private final static int batchSize = 10;

    private AdDAO() {
    }

    public static AdDAO getInstance() {
        if (dao == null)
            dao = new AdDAO();
        return dao;
    }

    @Override
    public void save(Ad ad) {
        EntityManager em = HibernateUtils.getInstance();
        em.getTransaction().begin();
        em.persist(ad);
        em.getTransaction().commit();
    }

    @Override
    public void save(List<Ad> ads) {
        EntityManager em = HibernateUtils.getInstance();
        em.getTransaction().begin();
        for (int i = 0; i < ads.size(); i++) {
            em.merge(ads.get(i));
            if (i % batchSize == 0 && i != ads.size()) {
                System.out.println(" Flush a batch of INSERT & release memory: {" + (i / batchSize) + "} time(s)");
                em.flush();
                em.clear();
            }
        }
        System.out.println("Flush the last time at commit time");
        em.getTransaction().commit();
    }
}
