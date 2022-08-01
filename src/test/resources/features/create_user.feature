Feature: create a new user

  Scenario: create a new user sucessfully
    Given that Jhon creates an user with his name and his job developer
    Then sees that the user was created sucessfully
