package dao.impl;

import dao.DAO;
import entity.AdGroup;
import utils.HibernateUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class AdGroupDAO implements DAO<AdGroup> {
    private static AdGroupDAO dao;

    private final static int batchSize = 10;

    private AdGroupDAO() {
    }

    public static AdGroupDAO getInstance() {
        if (dao == null)
            dao = new AdGroupDAO();
        return dao;
    }

    @Override
    public void save(AdGroup adGroup) {
        EntityManager em = HibernateUtils.getInstance();
        em.getTransaction().begin();
        em.persist(adGroup);
        em.getTransaction().commit();
    }

    @Override
    public void save(List<AdGroup> adGroups) {
        EntityManager em = HibernateUtils.getInstance();
        em.getTransaction().begin();
        for (int i = 0; i < adGroups.size(); i++) {
            em.merge(adGroups.get(i));
            if (i % batchSize == 0 && i != adGroups.size()) {
                System.out.println(" Flush a batch of INSERT & release memory: {" + (i / batchSize) + "} time(s)");
                em.flush();
                em.clear();
            }
        }
        System.out.println("Flush the last time at commit time");
        em.getTransaction().commit();
    }
}
