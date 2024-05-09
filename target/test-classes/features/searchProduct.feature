Feature: Search and place order for products

@OffersPage
Scenario Outline: Search experience for product search in both home and offers pages
Given User is on the GreenCart landing page
When User search with the shortname <Name> and extract the actual product name
Then User search with the same shortname <Name> in the offers page 
And  Validate product name in offers page matches with landing page 

Examples:
| Name |
| Tom  |
| Beet |