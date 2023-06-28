Feature: Add to cart and checkout



  Scenario: checkout the calculation of cart value
    Given  user is on GreenCart landing page
    When select the Cucumber and click on add to cart button
    Then Go to checkout page and proceed to checkout

  Scenario: Checkout the product name displayed properly in Checkout page
    Given user is on GreenCart landing page
    When select the Cucumber and click on add to cart button
    Then check whether  added product displayed properly

  Scenario: Login using Different Data Set
    Given open url
    When you search product and enter data
      | Names |
      | Beans |
      | cucumber |
    Then validate product is visible

  Scenario Outline: Login using Different Data Set 2
    Given open url
    When you search products and enter <Names>
    Then validate product is visible two

    Examples:
    | Names |
    | Beans |
    | cucumber |
    | B |
    | Beetroot |

  @heckout
  Scenario Outline: Login using Different Data Set 2
    Given open url
    When you search products and enter <Names>
    Then enter the random quantity and calculate the price.

    Examples:
      | Names |
      | Beans |
      | cucumber |
      | Tomato |
      | Beetroot |


