Feature: As a customer,
  I want to use a searchbox,
  so that I can easily find the sought product.

  Rule: It is allowed to use the search box

    Background:
      Given open main page
      And accept cookies

    Scenario Outline: search for a product
      Given language is set to "<language>"
      When customer searches for a "<product>"
      Then it shows results for "<product>"

      Examples:
        | language | product |
        | Magyar | kenyér |
        | English | bread |
