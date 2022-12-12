Feature: As a customer,
  I want to increase(48) or decrease(24) the number of displayed items,
  so that I can see more or less items on the page.

  Rule: It is allowed to change the amount of products shown on the page

    Background:
      Given open main page
      And accept cookies

    Scenario Outline: Change the amount of products to 24
      Given language is set to "<language>"
      When user searches for "<item>"
      And user sets "<24items>"
      Then "<items_shown>" on the page

      Examples:
        | language | item | 24items | items_shown |
        | hungarian | kenyér | 24 termék megjelenítése oldalanként | 24 |
        | english | bread | Show 24 per page | 24 |

    Scenario Outline: Change the amount of products to 24
      Given language is set to "<language>"
      When user searches for "<item>"
      And user sets "<48items>"
      Then "<items_shown>" on the page

      Examples:
        | language | item | 48items | items_shown |
        | hungarian | kenyér | 48 termék megjelenítése oldalanként | 48 |
        | english | bread | Show 48 per page | 48 |