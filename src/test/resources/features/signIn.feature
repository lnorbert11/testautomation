Feature: As a customer,
  I want to use my registered user account,
  so that I can put products to my basket.

  Rule: It is allowed to sign in to the application

    Background:
      Given open main page
      And accept cookies

    Scenario Outline: Change language
      Given language is set to "<language>"
      When user clicks on "<sign_in>"
      And user types "<email>"
      And user types "<password>"
      And user clicks on "<sign_in>"
      Then "<welcomeheader>" is shown

      Examples:
        | language | sign_in | email | password | welcomeheader |
        | hungarian | Bejelentkezés |gipsz.jakab@noreply.com | Qwerty1234 | Üdvözlünk Jakab |
        | english | Sign in | gipsz.jakab@noreply.com | Qwerty1234 | Hello Jakab |