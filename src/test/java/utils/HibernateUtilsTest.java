package utils;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

class HibernateUtilsTest {

    @Test
    void getInstance() {
        EntityManager em1 = HibernateUtils.getInstance();
        EntityManager em2 = HibernateUtils.getInstance();
        assertEquals(em1, em2);
    }
}