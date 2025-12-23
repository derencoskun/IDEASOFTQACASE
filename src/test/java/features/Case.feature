Feature: Case
  Scenario: Add to Cart
    Given Webpage is open
    When Search for "ürün"
    When Go to product detail
    When Add 5 pieces of product
    When Go to your Cart
    Then Check the number of the products in the cart is 5
