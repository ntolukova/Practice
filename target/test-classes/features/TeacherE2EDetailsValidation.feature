Feature: Teacher Details End to End for UI vs APIx

  @teacherData
  Scenario Outline: UI vs API cross data validation
    Given user gets teacher at "<resource>"
    And user goes to cybertek training application
    Then user opens teacher profile details page "<teacherID>"
    And user cross validates teacher details on API and on UI

    Examples:
      | resource      | teacherID |
      | /teacher/2827 | 2827      |
      | /teacher/2870 | 2870      |

  @teacherName
  Scenario Outline: UI vs API cross data validation with name
    Given user gets teacher at "<resource>"
    And user goes to cybertek training application
    Then user searches the teacher with "<teacherName>"
    And user cross validates "<teacherName>" on API and UI

    Examples:
      | resource              | teacherName |
      | /teacher/name/Biniska | Biniska     |

  @DBvsAPI
  Scenario Outline: API vs DB end to end data validation

    Given user gets teacher at "<resource>"
    And user connects to Cybertek Training DB
    Then user gets data from DB with "<teacherID>"
    And user cross validates API with DB
    Examples:
      | resource      | teacherID |
      | /teacher/2827 | 2827      |