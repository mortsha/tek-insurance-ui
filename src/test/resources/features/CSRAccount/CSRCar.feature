@regression
Feature: Launch the website, Login to account and add car

  Background: Lunch the website and login to CSR account
    Given User is on tek insurance app website and validate the website
    And User clicked on login button
    And User should be see the 'Sign in to your Account' title
    And User entered the username 'supervisor' and password 'tek_supervisor'
    When User clicked on	sign in
    Then The 'Customer Service Portal' title should be displayed
    And User should be see the 'Accounts' and 'Plans'
    And User click on profile and user type 'CSR' Full name 'Supervisor' username 'supervisor'
    And User click on close button to close the profile section
    Given The user click on Accounts
    And find the account with email 'mori1234@gmail.com' and click on details

  @AddCar
  Scenario: Adding Car to the account
    And User click on 'Cars' section
    When User click on 'Add Car' section button
    And validate the 'Add Car' text header
    Then The user fill the Car form with the below information
      | Make   | Model | Year | License Plate |
      | Toyota | Camry | 2023 | YMLS 999      |
    And The user click on submit button
    And validate the 'Car' section is present

  @DeletePhone
  Scenario: Adding Car to the account and delete the it
    And User click on 'Cars' section
    When User click on 'Add Car' section button
    And validate the 'Add Car' text header
    Then The user fill the Car form with the below information
      | Make   | Model | Year | License Plate |
      | Toyota | Camry | 2023 | YMLS 999      |
    And The user click on submit button
    And validate the 'Car' section is present
    And The user click on delete button of 'car'
    And The message Warning 'Delete phone' should be display
    And The user click on confirm button
    And the delete message should be display
