Feature: Automated End2End Tests
Description: The purpose of this feature is to test End 2 End Integration
Scenario: Customer place an Order by purchasing an product from search
Given User is on Home Page
When she searches for "dress"
And choose to buy first product
And moves to checkout from mini cart
And enter personal details on checkout page
And place the order