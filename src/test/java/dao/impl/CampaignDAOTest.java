package dao.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampaignDAOTest {

    @Test
    void getInstance() {
        CampaignDAO dao1 = CampaignDAO.getInstance();
        CampaignDAO dao2 = CampaignDAO.getInstance();
        assertEquals(dao1, dao2);
    }
}