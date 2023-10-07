@regression @createAccount
Feature: Create Primary Account with negative test

  Background: Launch the website and fill the SignUp form
    Given User is on tek insurance app website and validate the website
    And User click on create primary account button
    And the signUp page should be displayed
    And by the name of 'Create Primary Account Holder' text with 'Create Account' and 'Clear Form' buttons

  @CreateAccount
  Scenario: Launch the website and Create an primary account
    When user fill the form with below information
      | email                 | title | firstName | lastName | gender | maritalStatus | employmentStatus | dateOfBirth |
      | userTest@tekschool.us | Mr.   | Test      | User     | Male   | Single        | Software Tester  | 1990-09-10  |
    Then user click on Create Account button
    And another page should be displayed and validate the 'Sign up your account' text

  @CancelForm
  Scenario: Launch the website and fill the form and cancel the form
    When user fill the form with below information
      | email                 | title | firstName | lastName | gender | maritalStatus | employmentStatus | dateOfBirth |
      | userTest@tekschool.us | Mr.   | Test      | User     | Male   | Single        | Software Tester  | 1990-09-10  |
    Then user click on Cancel button
    And the fields should be removed

  @CreateAccountAndUserName
  Scenario: Launch the website and Create an primary account
    When user fill the form with below information
      | email                 | title | firstName | lastName | gender | maritalStatus | employmentStatus | dateOfBirth |
      | userTest@tekschool.us | Mr.   | Test      | User     | Male   | Single        | Software Tester  | 1990-09-10  |
    Then user click on Create Account button
    And another page should be displayed and validate the 'Sign up your account' text
    #And validate the exact email created before
    When fill the from for username and password
      | username | password  | confirmPassword |
      | username | smile7788 | smile7788       |
    Then sumbit the form

  @CreateAccountNegative
  Scenario: create account negative test with existing email
    When user fill form with below information
      | email              | title | firstName | lastName | gender | maritalStatus | employmentStatus | dateOfBirth |
      | mori1234@gmail.com | Mr.   | Test      | User     | Male   | Single        | Software Tester  | 1990-09-10  |
    Then user click on Create Account button
    Then the error should be display and say the account with this email is exist
