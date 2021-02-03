Feature: System Login

  Scenario: Valid login information results in a successful system login
    Given The system login screen is opened
    When The following e-mail is entered: "stu1801321063@uni-plovdiv.org"
    And The following password is entered: "nikipass"
    And The login button is clicked
    Then A login result message is seen: "You have successfully logged in!"
    
  Scenario: Invalid login information results in an error message
    Given The system login screen is opened
    When The following e-mail is entered: "brek"
    And The following password is entered: "continue"
    And The login button is clicked
    Then A login result message is seen: "The login credentials were invalid!"
    
  Scenario: Missing login information results in an error message
    Given The system login screen is opened
    When The login button is clicked
    Then A login result message is seen: "Please input a valid email!"
    
  Scenario: Missing e-mail results in an error message
    Given The system login screen is opened
    When The following password is entered: "whatever"
    And The login button is clicked
    Then A login result message is seen: "Please input a valid email!"
    
  Scenario: Missing password results in an error message
    Given The system login screen is opened
    When The following e-mail is entered: "123Ivan"
    And The login button is clicked
    Then A login result message is seen: "Please input a valid password!"
