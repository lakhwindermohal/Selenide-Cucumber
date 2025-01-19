Feature: Demo project setup

  Scenario: Demo project setup
    Given I have a demo project
    When I run the demo project
    Then I should see the demo project running

  Scenario: Verify google search top result
    Given I am on google search page
    When I search for "I want to work for Deloitte"
    Then I should see "Careers at Deloitte | Deloitte Australia" as the top result