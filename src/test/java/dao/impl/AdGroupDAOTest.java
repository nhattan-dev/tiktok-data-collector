package dao.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdGroupDAOTest {

    @Test
    void getInstance() {
        AdGroupDAO dao1 = AdGroupDAO.getInstance();
        AdGroupDAO dao2 = AdGroupDAO.getInstance();
        assertEquals(dao1, dao2);
    }
}