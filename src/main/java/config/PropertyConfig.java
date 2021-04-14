package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyConfig {

    static Properties prop = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/Config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropValue(String key) throws Exception {
        if (key != null && key.length() != 0) {
            return prop.getProperty(key);
        } else {
            throw new Exception("key is null or empty!");
        }
    }
}