Feature: As a customer,
  I want to be able to register to the application,
  so that I can purchase products.

  Rule: It is allowed to register to the application

    Background:
      Given open main page
      And accept cookies

    Scenario: Valid registration
      Given language is set to "hungarian"
      When user clicks on "register"
      And enters registration data
        | Email Address          | gipszjakab@noreply.com |
        | Password               | Password1234           |
        | Re-enter password      | Password1234           |
        | First Name             | Jakab                  |
        | Last Name              | Gipsz                  |
        | County                 | Baranya                |
        | Municipality           | Pécs                   |
        | Post code              | 7632                   |
        | Street                 | Melinda utca           |
        | House number           | 51                     |
        | Adress nickname        | otthon                 |
      Then "<welcomeheader>" is shown

