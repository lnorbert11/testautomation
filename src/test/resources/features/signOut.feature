@ImplementedFeature
Feature: As a customer,
  I want to be able to sign out from the page after the purchase,
  so that no one else can use my useraccount.

  Rule: It is allowed to sign out from the application

    Background:
      Given open main page
      And accept cookies

      @signout
    Scenario Outline: successful sign out
      Given language is set to "<language>"
      And customer is signed in "<sign_in>" with credentials "gipsz.jakab@noreply.com" and "Qwerty1234"
      When user clicks on "<sign_out>" sign out button
      Then "<sign_in>"  sign in link is shown

      Examples:
        | language | sign_out | sign_in |
        | Magyar | Kijelentkezés | Bejelentkezés |
        | English | Sign out | Sign in |