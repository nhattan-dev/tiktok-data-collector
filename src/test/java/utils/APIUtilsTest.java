package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class APIUtilsTest {

    @Test
    void get_then_throw_exception() {
        String args = String.format("{\"advertiser_id\": \"%s\"}"
                , 1234567865434657L);
        assertTrue(APIUtils.get(args, "", "") instanceof String);
    }
}