package utils;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReadFileUtilsTest {

    @Test
    void getPropValues_then_return_value() {
        String fileName = "test.properties";
        String propertyName = "test";
        String expect = "properties";
        String result = ReadFileUtils.getPropValues(fileName, propertyName);
        assertEquals(result, expect);
    }

    @Test
    void getPropValues_with_not_exists_property_then_return_null() {
        String fileName = "test.properties";
        String propertyName = "not-exist-property";
        String result = ReadFileUtils.getPropValues(fileName, propertyName);
        assertEquals(result, null);
    }

    @Test
    void getPropValues_with_not_exists_file_then_return_null() {
        String fileName = "not-exist-property.properties";
        String propertyName = "test";
        String result = ReadFileUtils.getPropValues(fileName, propertyName);
        assertEquals(result, null);
    }
}