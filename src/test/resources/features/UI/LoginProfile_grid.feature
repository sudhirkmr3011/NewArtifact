@LoginProfile
Feature: User Booking validation
  As an customer of careem application
  I want to login into my profile using my credentials
  In order to book a cab

  Scenario: Successful login using valid credentials
  	#Given I am on the company home page on URL "https://www.careem.com"
  	Given I grid am on the company home page on URL "LoginPageURL"
    When I grid click on "SignInLink"