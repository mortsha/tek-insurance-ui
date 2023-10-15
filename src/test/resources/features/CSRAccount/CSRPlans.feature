@regression @Plans
Feature: Launch the website and login to CSR and validate the Plans

  Background: click on the login button
    Given User is on tek insurance app website and validate the website
    And User clicked on login button
    And User should be see the 'Sign in to your Account' title
    
  Scenario: Login with CSR and verify the plans
    Given User entered the username 'supervisor' and password 'tek_supervisor'
    And User clicked on	sign in
    And The 'Customer Service Portal' title should be displayed
    When The User click on Plans
    And The text Todays Plans Price should be display
    Then The plan types 'Motorcycle' 'Boat' 'Renters' 'Auto' should be there
    And Date created should be todays date
    And Date expired should be one day after that date
