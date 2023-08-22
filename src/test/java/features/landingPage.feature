Feature: Add to cart and checkout

  @Regression
  Scenario: checkout the calculation of cart value
    Given  user is on GreenCart landing page
    When select the Cucumber and click on add to cart button
    Then Go to checkout page and proceed to checkout


  Scenario: Checkout the product name displayed properly in Checkout page
    Given user is on GreenCart landing page
    When select the Cucumber and click on add to cart button
    Then check whether  added product displayed properly

  @Regression
  Scenario: Login using Different Data Set
    Given open url
    When you search product and enter data
      | Names    |
      | Beans    |
      | cucumber |
    Then validate product is visible

  @Regression
  Scenario Outline: Login using Different Data Set 1
    Given open url
    When you search products and enter <Names>
    Then validate product is visible two

    Examples:
      | Names    |
      | Beans    |
      | cucumber |
      | B        |
      | Beetroot |

  @Regression
  Scenario Outline: Login using Different Data Set 2
    Given open url
    When you search products and enter <Names>
    Then enter the random quantity and calculate the price.

    Examples:
      | Names    |
      | Beans    |
      | cucumber |
      | Tomato   |
      | Beetroot |
      | Potato   |

  @Regression
  Scenario Outline: Login using Different Data Set 3
    Given open url
    When you search products and enter <Names>
    Then enter the random quantity in minus

    Examples:
      | Names  |
      | Tomato |

  @Regression
  Scenario: Login using Different Data Set 3
    Given open url
    When url is opened click on flight booking btn
    Then check flight booking window is opened and validate the title


  @Regression
  Scenario Outline:  Check Radio btns on FlightBooking
    Given user is on flightBooking site
    When  user clicks on <radiobutton>
    Then  radio buttons should be accessible and validated one by one
    Examples:
      | radiobutton |
      | one way     |

  @Regression
  Scenario: select dropdown
    Given user is on flightBooking site2
    When clicks on dropdown
    Then select value

  @Regression
  Scenario: select dropdown from flight from list
    Given user is on flightBooking site2
    When user clicked on dropdown from departure list randomly
    And user clicked on destination dropdown
    Then show both locations