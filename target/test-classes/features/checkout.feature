Feature: Search and place order for products

@PlaceOrder
Scenario Outline: Search experience for product search in both home and offers pages
Given User is on the GreenCart landing page
When User search with the shortname <Name> and extract the actual product name
#Then User search with the same shortname <Name> in the offers page 
And Added "3" items of the selected product to the cart
Then User proceeds to checkout and validate <Name> items in the checkout page 
#And Varify if user has the ability to apply promo code and place the order 

Examples:
| Name |
| Tom  |
