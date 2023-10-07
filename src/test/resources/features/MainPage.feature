@regression	@main
Feature: Launch to Main Page

  Scenario: Launch the website and validate the main page
    Given User is on tek insurance page and verify the 'TEK Insurance App' logo
    And Verify 'Lets get you started' text should be displayed
    And verify 'Create Primary Account' button should be displayed
