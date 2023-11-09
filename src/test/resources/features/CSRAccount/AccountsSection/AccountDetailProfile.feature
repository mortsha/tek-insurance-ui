@regression @Profile
Feature: CSR Account Profile Validation

  Background: Lunch the website and login to CSR account
    Given User is on tek insurance app website and validate the website
    And User clicked on login button
    When User entered the username 'supervisor' and password 'tek_supervisor'
    And User clicked on sign in
    And The user click on Accounts
    And find the account with email 'mori1234@gmail.com' and click on details
    And validate the title 'Primary Account detail' should be present

  Scenario Outline: Changing Account Status
    Given the user is on the 'Profile' section
    And the account status is '<currentStatus>'
    And the user can see the Full Name and Username
    When the user selects '<newStatus>' from the Profile Status dropdown
    Then the success message '<successMessage>' should be displayed
    And the account should be '<expectedStatus>' and display '<newStatus>'

    Examples: 
      | currentStatus | newStatus | expectedStatus | successMessage                |
      | Active        | Deactive  | Deactive       | User Successfully Deactivated |
      | Deactive      | Active    | Active         | User Successfully Activated   |
