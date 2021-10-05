package dao.impl;

import dao.AbstractDAO;
import entity.Campaign;

public class CampaignDAO extends AbstractDAO<Campaign> {
    private static CampaignDAO dao;

    private CampaignDAO() {
    }

    public static CampaignDAO getInstance() {
        if (dao == null)
            dao = new CampaignDAO();
        return dao;
    }
}
