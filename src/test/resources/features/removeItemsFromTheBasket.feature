Feature: As a customer,
  I want to be able to remove items form my basket,
  so that I can avoid to buy them.

  Rule: It is allowed to remove items from the basket

    Background:
      Given open main page
      And accept cookies

    Scenario: Removing item from the basket
      Given language is set to "english"
      Given there is an item in the basket
      When user clicks on remove item button
      Then Item is no more shown in the basket
