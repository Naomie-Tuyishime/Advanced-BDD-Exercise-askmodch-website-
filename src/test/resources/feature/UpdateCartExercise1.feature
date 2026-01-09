Feature:  Updating product in cart
  In order to Increase or decrease the product in cart
  as a customer on  askm online shopping website
  I want to Update cart successfully

  Scenario: Update product in  cart successfully
    Given I am in the cartPage  of the askomdch website
    When I increase or decrease the product quantity in cart
    Then  Product quantity in the cart should be updated
Scenario:  Remove product successfully
  Given I am in the cartPage
  When I remove a product from the cart
  Then the product should be removed from the cart