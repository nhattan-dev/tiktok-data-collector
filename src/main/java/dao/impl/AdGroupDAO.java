package dao.impl;

import dao.AbstractDAO;
import entity.AdGroup;

public class AdGroupDAO extends AbstractDAO<AdGroup> {
    private static AdGroupDAO dao;

    private AdGroupDAO() {
    }

    public static AdGroupDAO getInstance() {
        if (dao == null)
            dao = new AdGroupDAO();
        return dao;
    }
}
