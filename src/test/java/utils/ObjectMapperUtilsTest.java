package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObjectMapperUtilsTest {

    @Test
    void getInstance() {
        ObjectMapper m1 = ObjectMapperUtils.getInstance();
        ObjectMapper m2 = ObjectMapperUtils.getInstance();
        assertEquals(m1, m2);
    }
}