@LoginNegative
Feature: Login to the account and negative testing

  Background: click on the login button
    Given User is on tek insurance app website and validate the website
    And User clicked on login button
    And User should be see the 'Sign in to your Account' title
    
    
    @Negative1SCR
    Scenario: Login with wrong username and correct password to CSR home
    Given User enter the username 'supervis' and password 'tek_supervisor'
    When User clicked on	sign in
    Then The 'Customer Service Portal' title should be displayed
    
    @Negative2SCR
    Scenario: Login with correct username and wrong password to CSR home
    Given User enter the username 'supervisor' and password 'alaki1234'
    When User clicked on	sign in
    Then The 'Customer Service Portal' title should be displayed
    
    @Negative1PrimaryAccount
    Scenario: Login with wrong username and correct password to Primary Account home
    Given User enter the username 'mori' and password 'mori1234'
    When User clicked on	sign in
    Then The 'Primary Account Portal' should be displayed
    
    @Negative2PrimaryAccount
    Scenario: Login with correct username and wrong password to Primary Account home
    Given User enter the username 'mori123' and password 'mori0000'
    When User clicked on	sign in
    Then The 'Primary Account Portal' should be displayed