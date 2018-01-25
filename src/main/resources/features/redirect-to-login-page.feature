Feature: There's an option to log in from the main page

  @yellow
  Scenario: Redirect to login page
    Given I open url: "https://moz.com/"
    When I click on Log in button
    Then I check I am on login page