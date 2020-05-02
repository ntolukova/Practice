@StudentData
Feature: Student data validation

  @StudentListByBatch
  Scenario Outline: User should be able to get preferred students list by batch number
    Given user gets student at "<resource>"
    Then user should be able to see all the student list by "<batch>"
    Examples:
      | resource          | batch |
      | /student/batch/14 | 14    |
      | /student/batch/4  | 4     |

  @StudentDelete
  Scenario Outline:  User should be able to delete student using both API and UI.
    Given user deletes student with "<resource>"
    And user goes to cybertek training application
    And user searches the student by "<studentID>"
    Then user shouldn't be able to find the student on UI
    Examples:
      | resource             | studentID |
      | /student/delete/7667 | 7667      |

  @StudentCreate
  Scenario: User should be able to create a student, API E2E scenario
    Given user posts student with following data "/student/create"
      | firstName        | Lio             |
      | lastName         | Simba           |
      | emailAddress     | simba@gmail.com |
      | joinDate         | 01/01/2010      |
      | password         | 123jbr          |
      | subject          | Cartoon         |
      | phone            | 3124756521      |
      | gender           | Male            |
      | admissionNo      | 10              |
      | birthDate        | 01/01/1990      |
      | major            | Football        |
      | batch            | 10              |
      | section          | LaLigA          |
      | premanentAddress | 921 W Huron St. |
      | companyName      | Barcelona       |
      | title            | Goatie          |
      | startDate        | 01/02/2010      |
      | city             | Barcelona       |
      | street           | 13 Hurnon       |
      | zipCode          | 60742           |
      | state            | IL              |
    And user goes to cybertek training application
    And user searches for student with newly created studentID
    Then user verifies that student is created




