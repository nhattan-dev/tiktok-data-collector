package dao.impl;

import dao.DAO;
import entity.Campaign;
import utils.HibernateUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class CampaignDAO implements DAO<Campaign> {
    private static CampaignDAO dao;

    private final static int batchSize = 10;

    private CampaignDAO() {
    }

    public static CampaignDAO getInstance() {
        if (dao == null)
            dao = new CampaignDAO();
        return dao;
    }

    @Override
    public void save(Campaign campaign) {
        EntityManager em = HibernateUtils.getInstance();
        em.getTransaction().begin();
        em.persist(campaign);
        em.getTransaction().commit();
    }

    @Override
    public void save(List<Campaign> campaigns) {
        EntityManager em = HibernateUtils.getInstance();
        em.getTransaction().begin();
        for (int i = 0; i < campaigns.size(); i++) {
            em.merge(campaigns.get(i));
            if (i % batchSize == 0 && i != campaigns.size()) {
                System.out.println(" Flush a batch of INSERT & release memory: {" + (i / batchSize) + "} time(s)");
                em.flush();
                em.clear();
            }
        }
        System.out.println("Flush the last time at commit time");
        em.getTransaction().commit();
    }
}
