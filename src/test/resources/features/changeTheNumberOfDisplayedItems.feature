@ImplementedFeature
Feature: As a customer,
  I want to increase or decrease the number of displayed items,
  so that I can see more or less items on the page.

  Rule: It is allowed to change the amount of products shown on the page

    Background:
      Given open main page
      And accept cookies

    Scenario Outline: Change the amount of displayed products to 24
      Given language is set to "<language>"
      And customer searches for a "<product>"
      And More less link is set to "<48items>"
      When user sets "<24items>"
      Then "24" items are shown on the page

      Examples:
        | language | product | 24items |48items |
        | Magyar | kenyér | 24 termék megjelenítése oldalanként | 48 termék megjelenítése oldalanként |
        | English | bread | Show 24 per page | Show 48 per page |

    Scenario Outline: Change the amount of displayed products to 48
      Given language is set to "<language>"
      And customer searches for a "<product>"
      And More less link is set to "<24items>"
      When user sets "<48items>"
      Then "48" items are shown on the page

      Examples:
        | language | product | 24items | 48items |
        | Magyar | kenyér | 24 termék megjelenítése oldalanként | 48 termék megjelenítése oldalanként |
        | English | bread | Show 24 per page | Show 48 per page |

