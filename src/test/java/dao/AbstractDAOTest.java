package dao;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbstractDAOTest {

    @Test
    void save() {
        EntityManager em = Mockito.mock(EntityManager.class);
        Mockito.when(em.merge(Mockito.any())).thenReturn(null);
        Mockito.doNothing().when(em).flush();
        Mockito.doNothing().when(em).clear();
        AbstractDAO dao = Mockito.mock(AbstractDAO.class);
        dao.save(Mockito.anyList());
    }
}