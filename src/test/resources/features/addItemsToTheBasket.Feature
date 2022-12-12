Feature:_As a customer,
  I want to be able to put items to my basket,
  so that I can purchase them.

  Rule: It is allowed to add items to the basket

    Background:
      Given open main page
      And accept cookies

    Scenario: Adding items to the basket
      Given language is set to "english"
      When user search for products and adding them to the basket
      | Roberto Wholemeal Bread   |
      | Dublin Dairy Cheddar Red  |
      | Red California Paprika    |
      Then products are shown in the basket
