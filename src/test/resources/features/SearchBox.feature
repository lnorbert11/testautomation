Feature: As a customer,
  I want to use a searchbox,
  so that I can easily find the sought product.

  Rule: It is allowed to use the search box

    Background:
      Given open main page
      And accept cookies

    Scenario:
      When customer searches for an item
      Then results are shown
