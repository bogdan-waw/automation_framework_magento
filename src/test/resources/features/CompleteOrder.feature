@regression
Feature: Complete order

  @test
  Scenario Outline: Complete order
    Given The user navigates to home page
    Then The home page is displayed
    When The user goes to first product
    Then The product page is displayed
    When The user adds the product to cart with size <size> and color <color>
    And The user goes to cart
    Then The checkout shipping page is displayed
    When The user enters the shipping details on the checkout page
    And The user continues to payment
    Then The checkout payment page is displayed
    And The product details are correct
    When The user places the order
    Then The order completed page is displayed
    Examples:
      | size | color  |
      | s    | blue   |
      | m    | orange |