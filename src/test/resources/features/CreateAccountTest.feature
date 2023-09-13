@Regression
Feature: Create Primary Account

  #Launch to the website and validate that you are in the right website.
  #In the main Page click on the Create Primary Account button.
  #After that the sign up page should be displayed by the name of 'Create Primary Account Holder'
  # with 'Create Account' and 'Cancel Form' buttons.
  #Fill the Sign up form to create an account with valid information
  #Check for Positive Testing while you create an account the next page should be displayed
  #Check for Negative Testing while you cancel the form the information in the fields should be removed.
  Background: Launch the website and fill the SignUp form
    Given User is on tek insurance app website and validate the website
    And User click on create primary account button
    And the signUp page should be displayed
    And by the name of 'Create Primary Account Holder' text with 'Create Account' and 'Reset Form' buttons
    When user fill the form with below information
      | email                 | title | firstName | lastName | gender | maritalStatus | employmentStatus | dateOfBirth |
      | userTest@tekschool.us | Mr.   | Test      | User     | Male   | Single         | Software Tester  | 1990-10-10  |

  @CreateAccount
  Scenario: Launch the website and Create an primary account
    Then user click on Create Account button
    And another page should be displayed

  @CancelForm
  Scenario: Launch the website and fill the form and cancel the form
    Then user click on Cancel button
    And the fields should be removed
