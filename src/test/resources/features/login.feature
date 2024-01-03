@regression @Login
Feature: Login to the account with two different portals

  Background: click on the login button
    Given User is on tek insurance app website and validate the website
    And User clicked on login button
    And User should be see the 'Sign in to your Account' title

  @Login123
  Scenario Outline: Login to the CSR Home
    Given User entered the username '<Username>' and password '<Password>'
    When User clicked on sign in
    Then The '<Title>' title should be displayed
    And User should be see the sections 'Accounts'  'Plans'
    And User click on profile and user type '<UserType>' Full name '<FullName>' username '<username>'
    And User click on logout button
    And Validate the home page

    Examples: 
      | Username   | Password       | Title                   | UserType | FullName   | username   |
      | supervisor | tek_supervisor | Customer Service Portal | CSR      | Supervisor | supervisor |

  @Login456
  Scenario Outline: Login to the Customer home
    Given User entered the username '<Username>' and password '<Password>'
    When User clicked on sign in
    Then The '<Title>' title should be displayed
    And Validate some options like 'Dashboard' 'Request Quote' 'Plans' 'Payments' 'Settings'
    And User click on profile and user type '<UserType>' Full name '<FullName>' username '<username>'
    And User click on logout button
    And Validate the home page

    Examples: 
      | Username           | Password | Title                  | UserType | FullName     | username           |
      | mori1234@gmail.com | mori1234 | Primary Account Portal | CUSTOMER | Mori Sharifi | mori1234@gmail.com |

  @NegativeLogin
  Scenario Outline: Negative Login Scenarios
    Given User entered the username '<username>' and password '<password>'
    When User clicked on sign in
    Then User should see the Error message of '<error_message>'

    Examples: 
      | username           | password       | error_message           |
      | supervis           | tek_supervisor | User supervis not found |
      | supervisor         | tek_suppeeeer  | Password not matched    |
      | mori               | mori1234       | User mori not found     |
      | mori1234@gmail.com | ppppp8777      | Password not matched    |
