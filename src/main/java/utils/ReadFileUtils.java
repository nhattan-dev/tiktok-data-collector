package utils;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadFileUtils {

    private static final Logger logger = Logger.getLogger(ReadFileUtils.class);

    private ReadFileUtils() {
    }

    public static String getPropValues(String fileName, String propertyName) {
        InputStream inputStream = null;
        try {
            Properties prop = new Properties();
            inputStream = ReadFileUtils.class.getClassLoader().getResourceAsStream(fileName);
            if (inputStream != null)
                prop.load(inputStream);
            else {
                logger.error("property file '" + fileName + "' not found in the classpath");
                throw new FileNotFoundException("property file '" + fileName + "' not found in the classpath");
            }
            return prop.getProperty(propertyName);
        } catch (Exception e) {
            logger.error("Exception: " + e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error(e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
