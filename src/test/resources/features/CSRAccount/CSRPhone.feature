@regression @Phone
Feature: Launch the website, Login to account and add phone

  Background: Lunch the website and login to CSR account
    Given User is on tek insurance app website and validate the website
    And User clicked on login button
    And User should be see the 'Sign in to your Account' title
    When User entered the username 'supervisor' and password 'tek_supervisor'
    And User clicked on sign in
    And The 'Customer Service Portal' title should be displayed
    And User should be see the sections 'Accounts'  'Plans'
    And User click on profile and user type 'CSR' Full name 'Supervisor' username 'supervisor'
    And User click on close button to close the profile section
    And The user click on Accounts
    And find the account with email 'mori1234@gmail.com' and click on details

  @AddPhone
  Scenario: Adding Phone to the account
    When User click on 'Phones' section
    And User click on 'Add Phone' section button
    And validate the 'Add Phone' text header
    Then The user fill the Phone form with the below information
      | PhoneType | Phone number | Extention | Time    |
      | Mobile    |   2262229999 |           | Morning |
    And The user click on submit button
    And validate the 'Phone' section is present

  @DeletePhone
  Scenario: Adding Phone to the account and delete the it
    And User click on 'Phones' section
    When User click on 'Add Phone' section button
    And validate the 'Add Phone' text header
    Then The user fill the Phone form with the below information
      | PhoneType | Phone number | Extention | Time    |
      | Mobile    |   2262229999 |           | Morning |
    And The user click on submit button
    And validate the 'Phone' section is present
    And The user click on delete button of 'phone'
    And The message Warning 'Delete phone' should be display
    And The user click on confirm button
    And The message 'Delete phone' should be displayed
