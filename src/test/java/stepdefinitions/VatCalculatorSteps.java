package stepdefinitions;

import io.cucumber.java.en.And;
import org.example.pagefactory.CalkooVatCalculatorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class VatCalculatorSteps {

    CalkooVatCalculatorPage vatCalculatorPage = new CalkooVatCalculatorPage();

    @Given("I navigate to the VAT Calculator page")
    public void i_navigate_to_the_vat_calculator_page() {
        vatCalculatorPage.navigateToVatCalculatorPage();
    }

    @And("I click the {string} button")
    public void i_Click_The_Button(String buttonName) {
        if (buttonName.equals("Do not consent")) {
            vatCalculatorPage.clickDoNotConsentButton();
        }
    }

    @Then("I should see the country dropdown")
    public void i_should_see_the_country_dropdown() {
        assertTrue("Country dropdown should be visible", vatCalculatorPage.isCountryDropdownVisible());
    }

    @Given("I select {string} from the country dropdown")
    public void i_select_country_from_the_country_dropdown(String country) {
        vatCalculatorPage.selectCountry(country);
    }

    @Then("I should see that all VAT rate labels are clickable")
    public void i_should_see_that_all_vat_rate_labels_are_clickable() {
        assertTrue("All VAT rate labels should be clickable", vatCalculatorPage.areAllVatRateLabelsClickable());
    }

    @Then("I should see that all input field labels are clickable")
    public void i_should_see_that_all_input_field_labels_are_clickable() {
        assertTrue("All input field labels should be clickable", vatCalculatorPage.areAllInputFieldLabelsClickable());
    }

    @Given("I select a VAT rate {string}")
    public void i_select_a_VAT_rate(String rate) {
        vatCalculatorPage.selectVATRate(rate);
    }

    @And("I select {string} input field")
    public void i_Select_Input_Field(String inputType) {
        vatCalculatorPage.selectInputType(inputType);
    }

    @When("I enter a Net amount of {string}")
    public void i_enter_a_Net_amount_of(String netAmount) {
        vatCalculatorPage.enterNetAmount(netAmount);
    }

    @When("I enter a VAT amount of {string}")
    public void i_Enter_A_VAT_Amount_Of(String vatAmount) {
        vatCalculatorPage.enterVatAmount(vatAmount);
    }

    @When("I enter a Gross amount of {string}")
    public void i_Enter_A_Gross_Amount_Of(String grossAmount) {
        vatCalculatorPage.enterGrossAmount(grossAmount);
    }

    @Then("The Net amount should be {string}")
    public void the_Net_Amount_Should_Be(String expectedNetAmount) {
        assertEquals("The VAT amount should match", expectedNetAmount, vatCalculatorPage.getNetAmount());
    }

    @Then("The VAT amount should be {string}")
    public void the_VAT_amount_should_be(String expectedVATAmount) {
        assertEquals("The VAT amount should match", expectedVATAmount, vatCalculatorPage.getVATAmount());
    }

    @Then("The Gross amount should be {string}")
    public void the_Gross_amount_should_be(String expectedGrossAmount) {
        assertEquals("The Gross amount should match", expectedGrossAmount, vatCalculatorPage.getGrossAmount());
    }

    @Then("An error message should be displayed {string}")
    public void an_error_message_should_be_displayed(String expectedErrorMessage) {
        String actualErrorMessage = vatCalculatorPage.getErrorMessage();
        if (actualErrorMessage == null) {
            fail("The error message element was not found on the page.");
        } else {
            assertEquals("The error message should match", expectedErrorMessage, actualErrorMessage);
        }
    }

}
