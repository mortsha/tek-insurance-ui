@regression @createAccount
Feature: Create Primary Account with positive and negative tests

  Background: User Navigate to the signup page
    Given User is on tek insurance app website and validate the website
    And User click on create primary account button
    And the signUp page should be displayed
    And Validate the header 'Create Primary Account Holder' and buttons 'Create Account' 'Clear Form'

  @CAPositive
  Scenario: Successful Creation of a Primary Account with credential
    When user fill the form with below information
      | email                 | title | firstName | lastName | gender | maritalStatus | employmentStatus | dateOfBirth |
      | userTest@tekschool.us | Mr.   | Test      | User     | Male   | Single        | Software Tester  | 10-09-1990  |
    Then user click on Create Account button
    And another page is displayed with the text "Sign up your account"
    And Validate the firstName 'Test' lastName 'User' and email 'email' should be the same
    When fill the from for username and password
      | username | password  | confirmPassword |
      | username | smile7788 | smile7788       |
    Then The user submits the form
    And User should see the Success message of 'Your account successfully register'

  @CANegative
  Scenario: Creation of a Primary Account negative test with existing email
    When user fill form with below information
      | email              | title | firstName | lastName | gender | maritalStatus | employmentStatus | dateOfBirth |
      | mori1234@gmail.com | Mr.   | Test      | User     | Male   | Single        | Software Tester  | 10-09-1990  |
    Then user click on Create Account button
    Then the error should be display and the error message 'Account with email mori1234@gmail.com is exist'
    Then User click on Reset button
    And the fields should be removed

  @CALookup
  Scenario: Lookup account create account and after set username and password
    When user fill form with the below information
      | email              | title | firstName | lastName | gender | maritalStatus | employmentStatus | dateOfBirth |
      | mori1234@gmail.com | Mr.   | Test      | User     | Male   | Single        | Software Tester  | 12-12-1990  |
    Then user click on Create Account button
    And user navigate to sign up
    And user click on Login button
    And click on register here
    And fill the form with existing information provided before
      | emailAddress       | FirstName | LastName | DateOfBirth |
      | mori1234@gmail.com | Test      | User     | 12-12-1990  |
    And click on submit
    And User should see Success message of 'Found matching data for'
    And fill from for username and password
      | userName           | password  | confirmPassword |
      | mori1234@gmail.com | smile7788 | smile7788       |
    Then The user submits the form
    And User should see the Success message of 'You account Successfully register'
