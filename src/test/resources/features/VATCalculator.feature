Feature: VAT Calculator Functionality Validation

  Background:
    Given I navigate to the VAT Calculator page
    And I click the "Do not consent" button

  Scenario: Validate the presence of country dropdown
    Then I should see the country dropdown

  Scenario: Validate if VAT rate labels are clickable after selecting a country
    Given I select "France" from the country dropdown
    Then I should see that all VAT rate labels are clickable

  Scenario: Validate if input field labels are clickable
    Then I should see that all input field labels are clickable

  Scenario: Validate the correct VAT and Gross calculations based on Net
    Given I select "Germany" from the country dropdown
    And I select a VAT rate "19%"
    And I select "Price without VAT" input field
    When I enter a Net amount of "100"
    Then The VAT amount should be "19.00"
    And The Gross amount should be "119.00"

  Scenario: Validate the correct Net and Gross calculations based on VAT
    Given I select "Germany" from the country dropdown
    And I select a VAT rate "7%"
    And I select "Value-Added Tax" input field
    When I enter a VAT amount of "7"
    Then The Net amount should be "100.00"
    And The Gross amount should be "107.00"

  Scenario: Validate the correct Net and VAT calculations based on Gross
    Given I select "Hungary" from the country dropdown
    And I select a VAT rate "5%"
    And I select "Price incl. VAT" input field
    When I enter a Gross amount of "105"
    Then The Net amount should be "100.00"
    And The VAT amount should be "5.00"

  Scenario: Validate the maximum two decimal places for any amount
    Given I select "Germany" from the country dropdown
    And I select a VAT rate "19%"
    When I enter a Net amount of "100.123"
    Then An error message should be displayed "Amount should have maximum 2 decimal places"

  Scenario: Validate 9-digit limit for Net input field
    Given I select "Germany" from the country dropdown
    And I select a VAT rate "19%"
    And I select "Price without VAT" input field
    When I enter a Net amount of "1000000000"
    Then An error message should be displayed "Amount should not exceed 9 digits"

  Scenario: Validate negative input values for Net input field
    Given I select "Germany" from the country dropdown
    And I select a VAT rate "19%"
    And I select "Price without VAT" input field
    When I enter a Net amount of "-100"
    Then An error message should be displayed "Negative amounts are not allowed"