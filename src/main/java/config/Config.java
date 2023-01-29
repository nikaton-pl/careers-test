package config;

import java.io.InputStream;
import java.util.Properties;

public class Config {

    private final Properties properties;

    public Config() {
        properties = getProperties();
    }

    private Properties getProperties() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
            properties.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException(("Cannot load properties file: " + e));
        }
        return properties;
    }

    public java.lang.String getApplicationUrl() {
        return properties.getProperty("application.url");
    }

    public java.lang.String getApplicationWebDriver() {
        return properties.getProperty("application.webdriver");
    }

}
