@GetCEONAme
Feature: This feature is to get the CEO name from the OrangeHRM app
  Scenario Outline: This test is to verify CEO name
    Given User successfully logged in and is in Home page
    When the user clicks on directory option from menu bar
    And The user selects the job title as "Chief Executive Officer" from the dropdown using "text"
    And clicks the search button
    Then the user should see the CEO name as "John Smith"

