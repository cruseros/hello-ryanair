Feature: Failed payment end to end tests

When a user tries to end up a booking, he receives an error message declining credit card.

  @hola_mundo
  Scenario: Declined credit card
    Given that the user is not logged in
    When I make a booking from "DUB" to "MAD" on 22/07/2018
    And I pay for booking with card details "5555 5555 5555 5557", "10/2018" and "265"
    Then I should get payment declined message

