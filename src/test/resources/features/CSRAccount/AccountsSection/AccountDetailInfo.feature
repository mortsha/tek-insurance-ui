@regression @Info
Feature: Login to account and validate the information

  Background: Lunch the website and login to CSR account
    Given User is on tek insurance app website and validate the website
    And User clicked on login button
    When User entered the username 'supervisor' and password 'tek_supervisor'
    And User clicked on sign in
    And The user click on Accounts
    And find the account with email 'mori1234@gmail.com' and click on details

  Scenario: Validate the presence of information parts
    Given validate the title 'Primary Account Detail' should be present
    Then the information 'Email Address:' 'Gender:' 'Marital Status:' 'Employment Status:' 'Date of birth' should be present

  Scenario: Validate the information in each section
    Given validate the title 'Primary Account Detail' should be present
    Then the following information should be in
      | Email Address      | Gender | Marital Status | Employment Status | Date of Birth  |
      | mori1234@gmail.com | Male   | Single         | Tester            | August 1, 1990 |
