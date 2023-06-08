
Feature: Add to cart and checkout
  Scenario: checkout the calculation of cart value
    Given  user is on GreenCart landing page
    When select the Cucumber and click on add to cart button
    Then Go to checkout page and proceed to checkout

    Scenario: Checkout the product name displayed properly in Checkout page
      Given user is on GreenCart landing page
      When select the Cucumber and click on add to cart button
      Then check whether  added product displayed properly

