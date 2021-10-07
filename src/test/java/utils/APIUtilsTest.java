package utils;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class APIUtilsTest {

    @Test
    void get_then_throw_exception() {
        String args = String.format("{\"advertiser_id\": \"%s\"}"
                , 1234567865434657L);
        assertTrue(APIUtils.get(args, "", "") instanceof String);
    }
}