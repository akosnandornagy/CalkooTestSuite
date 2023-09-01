package org.example.pagefactory;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CalkooVatCalculatorPage extends BasePage {
    @FindBy(css = ".fc-button.fc-cta-do-not-consent.fc-secondary-button")
    private WebElement doNotConsentButton;

    @FindBy(name = "Country")
    private WebElement countryDropdown;

    @FindBy(xpath = "//div[text()='VAT rate']/following-sibling::div//label[@class='css-label']")
    private List<WebElement> vatRateLabels;

    @FindBy(xpath = "//label[@class='css-label' and @for='F1'] | //label[@class='css-label' and @for='F2'] | //label[@class='css-label' and @for='F3']")
    private List<WebElement> inputFieldLabels;

    @FindBy(id = "NetPrice")
    private WebElement inputPriceWithoutVAT;

    @FindBy(id = "VATsum")
    private WebElement inputValueAddedTax;

    @FindBy(id = "Price")
    private WebElement inputPriceInclVAT;

    // There is no error message element in tha page 👇👇👇
    @FindBy(id = "errorMessageElementID")
    private WebElement errorMessage;

    public void clickDoNotConsentButton() {
        try {
            wait.until(ExpectedConditions.visibilityOf(doNotConsentButton));
            if (doNotConsentButton.isDisplayed()) {
                doNotConsentButton.click();
            }
        } catch (TimeoutException e) {
            System.out.println("Consent modal did not appear, proceeding...");
        }
    }

    public void navigateToVatCalculatorPage() {
        driver.get(baseUrl + "/vat-calculator");
    }

    public boolean isCountryDropdownVisible() {
        return wait.until(ExpectedConditions.visibilityOf(countryDropdown)).isDisplayed();
    }

    public void selectCountry(String countryValue) {
        wait.until(ExpectedConditions.visibilityOf(countryDropdown));
        Select countrySelect = new Select(countryDropdown);
        countrySelect.selectByVisibleText(countryValue);
    }

    public boolean areAllVatRateLabelsClickable() {
        for (WebElement label : vatRateLabels) {
            wait.until(ExpectedConditions.elementToBeClickable(label));
        }
        return true;
    }

    public boolean areAllInputFieldLabelsClickable() {
        for (WebElement label : inputFieldLabels) {
            wait.until(ExpectedConditions.elementToBeClickable(label));
        }
        return true;
    }

    public void selectVATRate(String rate) {
        for (WebElement vatRateLabel : vatRateLabels) {
            if (vatRateLabel.getText().contains(rate)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", vatRateLabel);
                break;
            }
        }
    }

    public void selectInputType(String inputType) {
        for (WebElement inputFieldLabel : inputFieldLabels) {
            wait.until(ExpectedConditions.elementToBeClickable(inputFieldLabel));

            if (inputFieldLabel.getText().contains(inputType)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", inputFieldLabel);
                break;
            }
        }
    }

    public void enterNetAmount(String netAmount) {
        wait.until(ExpectedConditions.elementToBeClickable(inputPriceWithoutVAT));
        inputPriceWithoutVAT.clear();
        inputPriceWithoutVAT.sendKeys(netAmount);
        inputPriceWithoutVAT.sendKeys(Keys.TAB);
    }

    public void enterVatAmount(String netAmount) {
        wait.until(ExpectedConditions.elementToBeClickable(inputValueAddedTax));
        inputValueAddedTax.clear();
        inputValueAddedTax.sendKeys(netAmount);
        inputValueAddedTax.sendKeys(Keys.TAB);
    }

    public void enterGrossAmount(String netAmount) {
        wait.until(ExpectedConditions.elementToBeClickable(inputPriceInclVAT));
        inputPriceInclVAT.clear();
        inputPriceInclVAT.sendKeys(netAmount);
        inputPriceInclVAT.sendKeys(Keys.TAB);
    }

    public String getNetAmount() {
        return inputPriceWithoutVAT.getAttribute("value");
    }

    public String getVATAmount() {
        return inputValueAddedTax.getAttribute("value");
    }

    public String getGrossAmount() {
        return inputPriceInclVAT.getAttribute("value");
    }

    // There is no error message element in tha page 👇👇👇
    public String getErrorMessage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.getText();
        } catch (Exception e) {
            return null;
        }
    }
}
