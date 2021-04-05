@Login
Feature: Login page feature

@Smoke
Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Store"

@Smoke
Scenario: Forgot Password link
Given user is on login page
Then forgot your password link should be displayed

@Regression 
Scenario: Login with correct credentials
Given user is on login page
When user enters username "vajof28714@aramidth.com"
And user enters password "Test@123"
And user clicks on Login button
Then user gets the title of the page
And page title should be "My account - My Store"


@skip_scenario
Scenario: Check footer headings
Given user is on login page
Then social links visible on the page are 4


