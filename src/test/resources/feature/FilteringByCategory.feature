#Feature: Filtering products by category
#  In order to find products faster
#  As a customer on the AskOmDch website
#  I want to filter products by their categories
#
#  Scenario Outline: Filter products by category
#    Given I am on the store page
#    When I select the category "<category>"
#    Then I should see only products in the  category
#
#    Examples:
#      | category     |
#      | men        |
#      | women       |
#      | accessories  |
