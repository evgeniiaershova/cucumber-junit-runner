Feature: If a not registered user tries to log in, he is shown an error message

  @blue
  Scenario: User enters non existing creds and sees error message
    Given I open url: "https://moz.com/login"
    When I enter not existing login
    And I enter wrong password
    And I submit form
    Then I check I am on login page
    And I see "Invalid email or password." message
