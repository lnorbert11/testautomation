Feature: As a customer,
  I want to filter the products by categories,
  so that I can reduce the number of displayed items.

  Rule: It is allowed to to filter categories

    Background:
      Given open main page
      And accept cookies

    Scenario: filter product category
      Given language is set to "english"
      When customer clicks on "Fruit & Vegetables"
      And customer clicks on "All Fruit & Vegetables"
      And customer selects "Nuts & Seeds"
      Then only "Nuts & Seeds" are shown
