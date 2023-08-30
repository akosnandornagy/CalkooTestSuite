package org.example.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.example.config.ConfigReader;
import org.example.config.DriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = ConfigReader.getBaseUrl();

    public BasePage() {
        DriverManager driverManager = DriverManager.getInstance();
        this.driver = driverManager.getDriver();
        this.wait = driverManager.getWait();
        PageFactory.initElements(driver, this);
    }

    public void quitDriver() {
        DriverManager.getInstance().tearDown();
    }
}
