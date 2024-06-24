Feature: FlipKart_HomePage1

  @Regression
  Scenario Outline: Navigate to flipkart homepage

    Given User launches the Flipkart application
    When User Verify the loading time of the home page
    Then User searches for the record:"<productName>"
    And User fetch all searched products and its price

    Examples:
      | TestCaseId  | productName |
      | FlipKart_01 | iphone      |

  @Regression
  Scenario: Validate list of Existing products in flipkart

    Given User launches the Flipkart application
#    When User Validate list of products in the homePage




