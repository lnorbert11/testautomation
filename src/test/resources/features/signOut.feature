Feature: As a customer,
  I want to be able to sign out from the page after the purchase,
  so that no one else can use my useraccount.

  Rule: It is allowed to sign out from the application

    Background:
      Given open main page
      And accept cookies

    Scenario Outline: Change language
      Given language is set to "<language>"
      Given customer is signed in
      When user clicks on "<sign_out>"
      Then "<sign_in>" link is shown

      Examples:
        | language | sign_out | sign_in |
        | hungarian | Kijelentkezés | Bejelentkezés |
        | english | Sign out | Sign in |