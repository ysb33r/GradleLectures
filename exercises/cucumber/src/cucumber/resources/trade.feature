Feature: Basic Trade Example

  Scenario: Book a basic trade
    Given I have a trade
    When I book "INR" "1000.00" to "GBP"
    Then the result is "10.0"
