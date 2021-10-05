package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadFileUtils {

    private ReadFileUtils() {
    }

    public static String getPropValues(String fileName, String propertyName) throws IOException {
        InputStream inputStream = null;
        try {
            Properties prop = new Properties();
            inputStream = ReadFileUtils.class.getClassLoader().getResourceAsStream(fileName);
            if (inputStream != null)
                prop.load(inputStream);
            else
                throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
            return prop.getProperty(propertyName);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            if (inputStream != null)
                inputStream.close();
        }
        return "";
    }
}
