Feature: Return to Menu
	As a Tetris player
	I want to be able to return to the main menu
	In order to use the main menu options without restarting the application
	
Scenario: Return to main menu during running game
Given a Tetris game is running with initial default statistics
When the user selects the Game menu
And the user selects the "Return to Menu" button
Then the application should return to the main menu page

Scenario: Return to main menu during paused game
Given a Tetris game is paused
When the user selects the Game menu
And the user selects the "Return to Menu" button
Then the application should return to the main menu page