# Author:				carlosbarja@hotmail.com
# Date:					02/05/2021
# Description:	Test to show that the system can handle error y payments correctly

@PossibleTagHere
Feature: Payments

  @PossibleTagHere
  Scenario: Booking up to a declined payment
  	Given user is on Ryanair main page
    And user do login
    And user search for a flight
    And user introduces personal information
    And user selects details of flight
    And user confirms details and price
    When user pays with invalid credit card
    Then system should display a declined payment message
