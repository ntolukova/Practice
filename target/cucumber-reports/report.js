$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/StudentData.feature");
formatter.feature({
  "name": "Student data validation",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@StudentData"
    }
  ]
});
formatter.scenarioOutline({
  "name": "User should be able to delete student using both API and UI.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@StudentDelete"
    }
  ]
});
formatter.step({
  "name": "user deletes student with \"\u003cresource\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "name": "user goes to cybertek training application",
  "keyword": "And "
});
formatter.step({
  "name": "user searches the student by \"\u003cstudentID\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "user shouldn\u0027t be able to find the student on UI",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "resource",
        "studentID"
      ]
    },
    {
      "cells": [
        "/student/delete/7667",
        "7667"
      ]
    }
  ]
});
formatter.scenario({
  "name": "User should be able to delete student using both API and UI.",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@StudentData"
    },
    {
      "name": "@StudentDelete"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user deletes student with \"/student/delete/7667\"",
  "keyword": "Given "
});
formatter.match({
  "location": "StudentData_stepDefs.user_deletes_student_with(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user goes to cybertek training application",
  "keyword": "And "
});
formatter.match({
  "location": "TeacherE2EDataValidation_stepDefs.user_goes_to_cybertek_training_application()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user searches the student by \"7667\"",
  "keyword": "And "
});
formatter.match({
  "location": "StudentData_stepDefs.user_searches_the_student_by(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user shouldn\u0027t be able to find the student on UI",
  "keyword": "Then "
});
formatter.match({
  "location": "StudentData_stepDefs.user_shouldn_t_be_able_to_find_the_student_on_UI()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});