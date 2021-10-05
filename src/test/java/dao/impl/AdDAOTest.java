package dao.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdDAOTest {

    @Test
    void getInstance() {
        AdDAO dao1 = AdDAO.getInstance();
        AdDAO dao2 = AdDAO.getInstance();
        assertEquals(dao1, dao2);
    }
}