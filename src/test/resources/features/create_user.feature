Feature: Create a new user

  Scenario: Create a new user
    When Stev send a user creation request with his job developer
    Then he sees that the user was created