Feature: Login into account
	Existing stackoverflow user should be able to login into account using correct credentials
	
Scenario: Login into account with correct details
	Given User navigates to stackoverflow website
	And User clicks on the login button on homepage
	And User enters a valid username
	And User enters a valid password
	When User clicks on the login button
	Then User should be taken to the successful login page
	When User clicks on the selector button
	And  User clicks on the log out on model
	Then User should be taken to the successful log out page
	When User clicks on the Log out button
	And User should be taken to the successful home page
	