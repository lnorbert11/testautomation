Feature: As a customer,
  I want to be able to change the application's language,
  so that I can read the content and functions in different languages.

  Rule: It is allowed to change the language

    Background:
        Given open main page
        And accept cookies

    Scenario Outline: Change language
      Given language is set to "<language>"
      When change language to "<new_language>"
      Then it shows elements in "<new_language>"

      Examples:
       | language | new_language |
       | hungarian | english |
       | english | hungarian |