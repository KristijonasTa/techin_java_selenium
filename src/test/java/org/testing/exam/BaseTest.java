package org.testing.exam;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BaseTest {
    protected static WebDriver driver;

    public static WebDriver launchBrowser(String browserName) {
        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        return driver;
    }

    @BeforeEach
    void setup() {
        driver = launchBrowser("ie");
        driver.manage().window().maximize();
        driver.get("http://localhost:8080/");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}

