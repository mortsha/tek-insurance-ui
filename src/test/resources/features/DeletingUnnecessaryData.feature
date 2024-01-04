
Feature: Removing Unnecessary Data and Correcting Input Errors

  Background: Navigating and login to CSR account
    Given User is on tek insurance app website and validate the website
    And User clicked on login button
    And User entered the username 'supervisor' and password 'tek_supervisor'
    And User clicked on sign in
    And The user click on Accounts
    And User is on the Accounts page with the title 'Primary Accounts'

  
  Scenario: Removing Inaccurate Records with Database
    Given a connection to the database
    When retrieve abd identify the emails of accounts with null date of birth and remove the accounts
