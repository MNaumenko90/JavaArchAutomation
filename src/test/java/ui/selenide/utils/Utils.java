package ui.selenide.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Utils {

    public static Object getProperty(String nameProperty) {
        Properties prop = new Properties();

        try (InputStream input = Files.newInputStream(Paths.get("src/test/resources/platform.ui.properties"))) {

            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop.getProperty(nameProperty);
    }
}
