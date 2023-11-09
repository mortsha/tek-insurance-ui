@regression @Car
Feature: Launch the website, Login to account and add car

  Background: Lunch the website and login to CSR account
    Given User is on tek insurance app website and validate the website
    And User clicked on login button
    When User entered the username 'supervisor' and password 'tek_supervisor'
    And User clicked on sign in
    And The user click on Accounts
    And find the account with email 'mori1234@gmail.com' and click on details
    And validate the title 'Primary Account Detail' should be present

  @AddCar
  Scenario: Adding Car to the account
    And User click on 'Cars' section
    When User click on 'Add Car' section button
    And validate the 'Add Car' text header
    Then The user fill the Car form with the below information
      | Make  | Model      | Year | License Plate |
      | Dodge | Challanger | 2023 | YMLS 999      |
    And The user click on submit button
    And Validate the data of 'Car' is in account details

  @DeleteCar
  Scenario: Adding Car to the account and delete the it
    And User click on 'Cars' section
    When User click on 'Add Car' section button
    And validate the 'Add Car' text header
    Then The user fill the Car form with the below information
      | Make   | Model | Year | License Plate |
      | Toyota | Camry | 2023 | YMLS 999      |
    And The user click on submit button
    And Validate the data of 'Car' is in account details
    And The user click on delete button of 'car'
    And The message Warning 'Confirm Delete' should be display
    And The user click on confirm button
    And The message 'Car with id' id 'has been deleted' should be displayed in car section
