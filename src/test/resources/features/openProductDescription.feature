Feature: As a customer,
  I want to be able to open a product,
  so that I can see its detailed description.

  Rule: It is allowed to remove items from the basket

    Background:
      Given open main page
      And accept cookies

#    Scenario: Open product description
#      Given language is set to "english"
#      When customer searches for an item
#      And opens it
#      Then detailed description is shown about the item


    Scenario Outline: Open product description
      Given language is set to "<language>"
      When customer searches for a "<product>"
      And customer opens product page
      Then it shows "<product>" product description

      Examples:
        | language | product |
        | Magyar | Roberto durumbúza kenyér extra szűz olívaolajjal 400 g |
        | English | Marlenka Honey Nuggets with Cocoa 235 g |