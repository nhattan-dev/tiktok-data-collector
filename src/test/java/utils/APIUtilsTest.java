package utils;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;

class APIUtilsTest {

    @Test
    void get_with_wrong_args_then_throw_exception(){
        Exception exception = assertThrows(MismatchedInputException.class,
                () -> APIUtils.get("", "", ""));
        assertTrue(exception.getMessage().contains("No content to map due to end-of-input"));
    }

    @Test
    void get_then_throw_exception() throws IOException, URISyntaxException {
        String args = String.format("{\"advertiser_id\": \"%s\"}"
                , 1234567865434657L);
        assertTrue(APIUtils.get(args, "", "") instanceof String);
    }
}