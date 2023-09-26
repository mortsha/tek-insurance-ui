@Login
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
    Given User entered the username 'mori123' password 'mori1234'
    When User clicked on sign in button
    Then The 'Primary Account Portal' should be displayed
    And Validate some options like 'Dashboard' 'Plans' 'Payments' 'Settings'
    And User click on profile section and user type 'CUSTOMER' FullName 'Mroi Shi' username 'mori123'
    And User click on logout button
    
    
