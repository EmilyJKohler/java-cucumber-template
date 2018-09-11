Feature: Google search
  As a Google user
  I want to be able to search by phrase
  So that I can find web pages related to provided phrase


  Scenario Outline: Google search
    Given I'm on google.co.uk main page
    When I enter search phrase <searchPhrase>
    And I click search
    Then Link <link> should be displayed as first one

    Examples:
      | searchPhrase   | link                        |
      | "google co uk" | "https://www.google.co.uk/" |

  Scenario: One
    Given I am on the PHPTravels homepage
    When I click on the 'Sign Up' button located under 'My Account'
    And I fill in the form with valid details
    Then I should be able to create an account

  Scenario: Two
    Given I am on the PHPTravels home page
    When I want to login to my account
    Then I should be able to login

  Scenario: Three
    Given I am on PHPTravels
    When I go to book a tour
    Then The invoice should show

  Scenario: Four
    Given I am on the PHPTravels mainpage
    When I go to book a flight
    Then The invoice should be there

  @smoke
  Scenario: Five
    Given I'm on the homepage
    When I go to book a hotel
    And I want to select check-in and check-out dates

  Scenario: Six
      Given I am on the login page
      When I enter incorrect user information
      Then I should receive an error message