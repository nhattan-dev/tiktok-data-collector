package dao.impl;

import dao.AbstractDAO;
import entity.Ad;

public class AdDAO extends AbstractDAO<Ad> {
    private static AdDAO dao;

    private AdDAO() {
    }

    public static AdDAO getInstance() {
        if (dao == null)
            dao = new AdDAO();
        return dao;
    }
}
