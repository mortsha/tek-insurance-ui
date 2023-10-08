@regression @Login
Feature: Login to the account with two different portals

  Background: click on the login button
    Given User is on tek insurance app website and validate the website
    And User clicked on login button
    And User should be see the 'Sign in to your Account' title

  @CSRLogin
  Scenario: Login to the CSR home
    Given User entered the username 'supervisor' and password 'tek_supervisor'
    When User clicked on	sign in
    Then The 'Customer Service Portal' title should be displayed
    And User should be see the 'Accounts' and 'Plans'
    And User click on profile and user type 'CSR' Full name 'Supervisor' username 'supervisor'
    And User click on logout button

  @PrimaryAccountLogin
  Scenario: Login to the Customer home
    Given User entered the username 'mori1234@gmail.com' password 'mori1234'
    When User clicked on sign in button
    Then The 'Primary Account Portal' should be displayed
    And Validate some options like 'Dashboard' 'Plans' 'Payments' 'Settings'
    And User click on profile section and user type 'CUSTOMER' FullName 'Mori Sharifi' username 'mori1234@gmail.com'
    And User click on logout button

  @Negative1SCR
  Scenario: Login with wrong username and correct password to CSR home
    Given User enter the username 'supervis' and password 'tek_supervisor'
    When User clicked on	sign in
    And User should see the Error message of User not found

  @Negative2SCR
  Scenario: Login with correct username and wrong password to CSR home
    Given User enter the username 'supervisor' and password 'alaki1234'
    When User clicked on	sign in
    And User should see the Error message of Password not matched

  @Negative1PrimaryAccount
  Scenario: Login with wrong username and correct password to Primary Account home
    Given User enter the username 'mori' and password 'mori1234'
    When User clicked on	sign in
    And User should see the Error message of User not found

  @Negative2PrimaryAccount
  Scenario: Login with correct username and wrong password to Primary Account home
    Given User enter the username 'mori1234@gmail.com' and password 'mori0000'
    When User clicked on	sign in
    And User should see the Error message of Password not matched

  @Plans
  Scenario: Login with CSR and verify the plans
    Given User entered the username 'supervisor' and password 'tek_supervisor'
    And User clicked on	sign in
    And The 'Customer Service Portal' title should be displayed
    When The User click on Plans
    And The text Todays Plans Price should be display
    Then The plan types 'Motorcycle' 'Boat' 'Renters' 'Auto' should be there
    And Date created should be todays date
    And Date expired should be one day after that date
