@timesheets
Feature: This feature is to get pending timesheet
  Scenario Outline: This test is to verify the pending timesheet
    Given User is on the Home page
    When the user clicks on the time option from the menu
    And the user enters the name as "John Smith"
    And clicks the view button
    Then the user should see the message as "No Timesheets Found"
  
      
      
      
      
