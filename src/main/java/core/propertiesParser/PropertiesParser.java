package core.propertiesParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesParser {

    public static String getProperty(String propertyKey) {
        String value = getPropertyInstance().getProperty(propertyKey);
        if (value.equals("null")) throw new NullPointerException();
        return value;
    }

    private static Properties getPropertyInstance() {

        FileInputStream inputStream;
        Properties instance = new Properties();

        try {
            inputStream = new FileInputStream("src/main/resources/dataFiles/global.properties");
            instance.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return instance;
    }
}
