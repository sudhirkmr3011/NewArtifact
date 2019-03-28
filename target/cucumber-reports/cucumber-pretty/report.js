$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/UI/LoginProfile.feature");
formatter.feature({
  "line": 2,
  "name": "User Booking validation",
  "description": "As an customer of careem application\nI want to login into my profile using my credentials\nIn order to book a cab",
  "id": "user-booking-validation",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@LoginProfile"
    }
  ]
});
formatter.scenario({
  "comments": [
    {
      "line": 7,
      "value": "#  Background: User navigates to home page"
    },
    {
      "line": 8,
      "value": "#    Given I am on the company home page on URL \"https://www.careem.com\""
    }
  ],
  "line": 11,
  "name": "Successful login using valid credentials",
  "description": "",
  "id": "user-booking-validation;successful-login-using-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 10,
      "name": "@mayank"
    }
  ]
});
formatter.step({
  "line": 12,
  "name": "I am on the company home page on URL \"LoginPageURL\"",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "I click on \"SignInLink\"",
  "keyword": "When "
});
formatter.match({
  "arguments": [
    {
      "val": "LoginPageURL",
      "offset": 38
    }
  ],
  "location": "CommonStep.i_am_on_the_page_on_URL(String)"
});
formatter.result({
  "duration": 3692151740,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "SignInLink",
      "offset": 12
    }
  ],
  "location": "CommonStep.i_click_on_the_element(String)"
});
formatter.result({
  "duration": 3182277395,
  "status": "passed"
});
});