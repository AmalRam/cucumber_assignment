Feature:   Search Functionality for Monster India


Background:
					Given the user is on Monster login page
					
Scenario:
        When the user enters into login page
				And enters the email id
			  And enters the password
				And clicks the login button
				Then the dashboard page should be displayed
				
				When the user enters a search keyword
				And click the search icon
				Then the search result should be displayed
				
				
				When the user hover on to the icon
				And click on the logout button
				Then the user is able to logout from the page