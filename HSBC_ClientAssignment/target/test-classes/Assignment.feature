Feature: Test the success status of latest foreign exchange rates API
Scenario: Verify the success status of latest foreign exchange api response
	Given Rates API for latest foreign exchange rates 
	When The API is Available
	Then Verify the success status code of the response is success