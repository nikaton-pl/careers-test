package pages;

import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BasePageTest {
    protected WebDriver driver;
    protected Config config = new Config();
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";

    @BeforeEach
    public void driverStart() {
        switch (config.getApplicationWebDriver()) {
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            default:
                try {
                    throw new Exception("Not supported webdriver!");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(config.getApplicationUrl());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
