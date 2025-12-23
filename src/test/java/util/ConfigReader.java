package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static java.lang.System.getProperties;

public class ConfigReader {

    private static Properties properties;

    public static Properties getProperties() {
        if (properties == null) {
            try {
                properties = new Properties();
                FileInputStream fis =
                        new FileInputStream("src/main/resources/config.properties");
                properties.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }
}