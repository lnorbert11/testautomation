@ImplementedFeature
Feature:As a customer,
  I want to be able to put items to my basket,
  so that I can purchase them.

  Rule: It is allowed to add items to the basket

    Background:
      Given open main page
      And accept cookies

    Scenario: Adding items to the basket
      Given language is set to "English"
      And customer is signed in "Sign in" with credentials "gipsz.jakab@noreply.com" and "Qwerty1234"
      When user searches for products and adding them to the basket
      Then products are shown in the basket

