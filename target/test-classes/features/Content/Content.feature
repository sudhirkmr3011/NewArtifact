@LoginProfile
Feature: User Booking validation
  As an customer of careem application
  I want to login into my profile using my credentials
  In order to book a cab
    
@test
  Scenario Outline: Successful login using valid credentials
  	Given I am on the company home page on URL "LoginPageURL"
    Then I check content on page "home"
#    When I click on "SignInLink"
#    Then I check content on page "signin"
#    When I click on "CreateAccount"
#    Then I check content on page "CreateAccount"
    
    Examples:
      | username    								| password   			| Message |
      | mayank0905@gmail.com        | test@123        | Hi |