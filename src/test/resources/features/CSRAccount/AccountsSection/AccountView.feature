@regression @AccountView
Feature: Website Login and Data Validation

  Background: User logs in to the tek insurance app
    Given User is on tek insurance app website and validate the website
    And User clicked on login button
    And User entered the username 'supervisor' and password 'tek_supervisor'
    And User clicked on sign in
    And The user click on Accounts
    And User is on the Accounts page with the title 'Primary Accounts'

  @RetrieveUI
  Scenario: Retrieve and store data from uiWebsite
    When User select '50' from show dropdown
    Then User retrieves and stores data from the uiWebsite

  @RetrieveDB
  Scenario: Retrieve and store data from the database
    When User retrieves and stores data from the database

  @ValidateData
  Scenario: Validate that data from uiWebsite matches data from the database
    When User select '50' from show dropdown
    And User retrieves and stores data from the uiWebsite
    And User retrieves and stores data from the database
    Then Validate that the data from uiWebsite matches the data from the database

  @CreateAccountBttn
  Scenario: Validate Create Primary Account button
    When User click on 'Create Primary Account' button
    Then another page should be displayed with the header 'Create Primary Account Holder'
