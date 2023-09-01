# VAT Calculator Test Automation

## Description

This project aims to automate the testing process for a VAT calculator available on Calkoo's website. It validates the calculator's functionality against specific acceptance criteria, leveraging Selenium and Cucumber for test automation.

## User Story

As a traveler, the user wants to calculate various purchase/tax amounts to verify if their shop receipt is correct, and whether the merchant has charged the correct VAT.

## Acceptance Criteria

- User must select a country that applies the VAT scheme.
- User must be able to choose a valid VAT rate for the selected country.
- One of the following amounts is supported as an input: Net, Gross, VAT.
- Amounts can be entered with a maximum of 2 decimal digit precision.
- Given all mandatory fields are provided, the calculator will show the other 2 amounts not originally provided as input.
- Proper error handling for negative inputs and amounts exceeding 999,999,999.

## Technologies Used

- Java
- Selenium WebDriver
- Cucumber
- Maven

## Installation

### Prerequisites

- Java JDK installed
- Maven installed
- Chrome browser installed

### Setup

```bash
git clone https://github.com/akosnandornagy/CalkooTestSuite.git
cd CalkooTestSuite
mvn clean install
```

## Usage

To run the test cases, execute the following command:

```bash
mvn test
```

## Test Cases

Automated test cases cover various aspects of the VAT calculator's functionality, including but not limited to:

1. Validate the presence of the country dropdown.
2. Validate if VAT rate labels are clickable after selecting a country.
3. Validate if input field labels are clickable.
4. Validate the correct VAT and Gross calculations based on Net.
5. Validate the correct Net and Gross calculations based on VAT.
6. Validate the correct Net and VAT calculations based on Gross.
7. Validate the maximum two decimal places for any amount.
8. Validate 9-digit limit for Net input field.
9. Validate negative input values for Net input field.

### Why These Test Cases?

These test cases aim to cover all aspects of the user story and acceptance criteria, ensuring that the VAT calculator behaves as expected.

## Questions Regarding Requirements/Acceptance Criteria

1. **API Testing**: The project currently focuses on testing through the web interface. Is there a requirement or plan to include API testing? If so, could you please provide the API endpoint?
2. **Error Message for Negative Amounts**: The web interface does show an error message in the pie chart section when negative amounts are entered. Is this considered sufficient, or should there be a more explicit error message next to the input field?
3. **9-Digit Limit**: The web interface restricts users from entering more than 9 digits but does not display an error message. Is this behavior considered acceptable according to the acceptance criteria?

## Contact Information

dr. Nándor Ákos Nagy - akos.nandor.nagy@gmail.com  
Project Link: https://github.com/akosnandornagy/CalkooTestSuite.git
