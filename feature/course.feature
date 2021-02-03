Feature: Course Creation

  Scenario: Valid course name and teacher e-mail results in the course being created
    Given The course creation screen is opened
    When The following teacher e-mail is entered: "john.brek@uni-plovdiv.org"
    And The following course name is entered: "Intro to Java"
    And The create course button is clicked
    Then A message is seen: "You have successfully created the course!"
    
  Scenario: Invalid course name results in an error message
    Given The course creation screen is opened
    When The following teacher e-mail is entered: "john.brek@uni-plovdiv.org"
    And The create course button is clicked
    Then A message is seen: "Please input a valid course name!"
    
  Scenario: Invalid teacher e-mail results in an error message
    Given The course creation screen is opened
    When The following course name is entered: "Intro to Java"
    And The create course button is clicked
    Then A message is seen: "Please input a valid teacher e-mail!"
    
  Scenario: Owner not being found results in an error message
    Given The course creation screen is opened
    When The following teacher e-mail is entered: "asdasdasdasd@uni-plovdiv.org"
    And The following course name is entered: "Intro to Java"
    And The create course button is clicked
    Then A message is seen: "The teacher could not be found!"
    
  Scenario: Missing information results in an error message
    Given The course creation screen is opened
    When The create course button is clicked
    Then A message is seen: "Please input a valid course name!"
