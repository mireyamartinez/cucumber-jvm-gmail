@gmail
Feature: User is unable to login

  Scenario: User cannot login if username or password are incorrect
    Given I am on Gmail homepage
    When I enter incorrect login credentials
    Then I should see message for incorrect credentials

  Scenario: User is prompted to enter email address if left blank
    Given I am on Gmail homepage
    When I leave "email address" blank and continue
    Then I should see message to enter email address

  Scenario: User is prompted to enter password if left blank
    Given I am on Gmail homepage
    When I leave "password" blank and continue
    Then I should see message enter  password

