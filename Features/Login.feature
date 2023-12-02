#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Login
Feature: Title of your feature
  I want to use this template for my feature file

  @NavigateToGoogle
  Scenario: Navigate to google
    Given get Driver Instance
    And Navigate to "https://www.google.com/"

  @NavigateToYahoo
  Scenario: Navigate to yahoo
    Given get Driver Instance
    And Navigating "https://www.yahoo.com/"

  @NavigateToNIT
  Scenario Outline: Navigate to multiple pages
    Given get Driver Instance
    And Navigating "<url>"

    Examples: 
      | url                     |
      | https://www.nitt.edu/   |

