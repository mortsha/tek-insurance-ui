@regression @Phone
Feature: Launch the website, Login to account and add phone

  Background: Lunch the website and login to CSR account
    Given User is on tek insurance app website and validate the website
    And User clicked on login button
    When User entered the username 'supervisor' and password 'tek_supervisor'
    And User clicked on sign in
    And The user click on Accounts
    And find the account with email 'mori1234@gmail.com' and click on details
    And validate the title 'Primary Account detail' should be present

  @AddPhone
  Scenario: Adding Phone to the account
    When User click on 'Phones' section
    And User click on 'Add Phone' section button
    And validate the 'Add Phone' text header
    Then The user fill the Phone form with the below information
      | PhoneType | Phone number | Extention | Time    |
      | Mobile    |   2262229999 |           | Morning |
    And The user click on submit button
    And Validate the data of 'Phone' is in account details

  @DeletePhone
  Scenario: Adding Phone to the account and delete the it
    And User click on 'Phones' section
    When User click on 'Add Phone' section button
    And validate the 'Add Phone' text header
    Then The user fill the Phone form with the below information
      | PhoneType | Phone number | Extention | Time    |
      | Mobile    |   2262229999 |           | Morning |
    And The user click on submit button
    And Validate the data of 'Phone' is in account details
    And The user click on delete button of 'phone'
    And The message Warning 'Confirm Delete' should be display
    And The user click on confirm button
    And The message 'Phone with id' id 'has been deleted' should be displayed in phone section
