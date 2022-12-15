#@ImplementedFeature
Feature: As a customer,
  I want to use my registered user account,
  so that I can put products to my basket.

  Rule: It is allowed to sign in to the application

    Background:
      Given open main page
      And accept cookies


    Scenario Outline: successful login
      Given language is set to "<language>"
      When user clicks on "<sign_in>" button and logs in with "<email>" and "<password>"
      Then "<welcomeheader>" is shown

      Examples:
        | language | sign_in | email | password | welcomeheader |
        | Magyar | Bejelentkezés |gipsz.jakab@noreply.com | Qwerty1234 | Üdvözlünk Jakab |
        | English | Sign in | gipsz.jakab@noreply.com | Qwerty1234 | Hello Jakab |