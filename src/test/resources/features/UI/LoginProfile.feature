@LoginProfile
Feature: User Booking validation
  As an customer of careem application
  I want to login into my profile using my credentials
  In order to book a cab

#  Background: User navigates to home page
#    Given I am on the company home page on URL "https://www.careem.com"
    
@mayank
  Scenario: Successful login using valid credentials
  	Given I am on the company home page on URL "LoginPageURL"
    When I click on "SignInLink"