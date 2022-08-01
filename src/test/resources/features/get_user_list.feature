Feature: get user list

  Scenario: get user list sucessfully
    When Andrea request the list of users
    Then sees the user list sucessfully
    And sees Lindsay in the list