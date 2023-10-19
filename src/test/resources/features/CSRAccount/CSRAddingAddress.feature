@regression @Address
Feature: Launch the website, Login to account and add address

  Background: Lunch the website and login to CSR account
    Given User is on tek insurance app website and validate the website
    And User clicked on login button
    And User should be see the 'Sign in to your Account' title
    When User entered the username 'supervisor' and password 'tek_supervisor'
    And User clicked on sign in
    And The 'Customer Service Portal' title should be displayed
    And User click on profile and user type 'CSR' Full name 'Supervisor' username 'supervisor'
    And User click on close button to close the profile section
    And The user click on Accounts
    And find the account with email 'mori1234@gmail.com' and click on details

  @AddAddress
  Scenario: Adding address to the account
    And User click on 'Mailing Address' section
    When User click on 'Add Mailing Address' section button
    And validate the 'Add Address' text header
    Then The user fill the form with the below information
      | AddressType | AddressLine | City    | State   | ZipCode |
      | Apartments  | 1010 Jali   | Toronto | Ontario | N6T 9Z8 |
    And The user click on submit button
    And validate the address is present

  @DeleteAddress
  Scenario: Adding address to the account and delete the address
    And User click on 'Mailing Address' section
    When User click on 'Add Mailing Address' section button
    And validate the 'Add Address' text header
    And The Your current address checkbox is 'off' selected
    Then The user fill the form with the below information
      | AddressType | AddressLine | City     | State   | ZipCode |
      | Apartments  | 1010 Khali  | Hamilton | Ontario |   84571 |
    And The user click on submit button
    And validate the address is present
    And The user click on delete button of 'Address'
    And The message Warning 'Delete address' should be display
    And The user click on confirm button
    And The message 'Delete address' should be displayed
    #And the delete message should be display
    #And the address should be deleted from account detail
