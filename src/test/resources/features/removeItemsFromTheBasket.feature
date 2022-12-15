@ImplementedFeature
Feature: As a customer,
  I want to be able to remove items form my basket,
  so that I can avoid to buy them.

  Rule: It is allowed to remove items from the basket

    Background:
      Given open main page
      And accept cookies

    Scenario: Removing item from the basket
      Given language is set to "English"
      And customer is signed in "Sign in" with credentials "gipsz.jakab@noreply.com" and "Qwerty1234"
      And there are items in the basket
      When user removes every item from the basket
      Then there is no items in the basket
