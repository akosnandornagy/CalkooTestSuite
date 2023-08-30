package org.example.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class DriverManager {
    private static DriverManager instance;
    private WebDriver driver;
    private WebDriverWait wait;

    private DriverManager() {
        setUp();
    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    private void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebDriver getDriver() {
        if (driver == null) {
            setUp();
        }
        return driver;
    }

    public WebDriverWait getWait() {
        if (wait == null) {
            setUp();
        }
        return wait;
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
            wait = null;
        }
    }
}
