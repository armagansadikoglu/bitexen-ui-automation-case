Feature: Amazon Search And Cart

  Scenario: Search A Product and Add to Cart
    Given user searches for "iphone"
    When user selects any product
    And adds product to the cart
    And goes to the cart
    Then user checks the cart