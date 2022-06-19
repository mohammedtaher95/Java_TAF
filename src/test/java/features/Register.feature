Feature: Register User

  Background:
    Given the user opened login page

  Scenario: User can Register on the website successfully
    When user enters his email for the first time
    And clicks on Create an account button
    Then Registration page should be displayed successfully
    When user fills his own data
