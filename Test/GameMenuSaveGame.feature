Feature:
	As a Tetris player
	I want to be able to save my game
	In order to stop the game and return later

Scenario: Save a game with initial default statistics
Given a Tetris game is running with initial default statistics
When the user selects the Game menu
And the user selects the Save Game button and enters "Test"
Then the data file should be updated with the "initial" statistics

Scenario: Save a game with changed statistics
Given a Tetris game is running with changed statistics
When the user selects the Game menu
And the user selects the Save Game button and enters "Test"
Then the data file should be updated with the "changed" statistics


Scenario: Save a game with no name
Given a Tetris game is running with initial default statistics
When the user selects the Game menu
And the user selects the Save Game button and enters ""
Then the data file should be updated with the "initial" statistics


Scenario: Save a game with a name too long
Given a Tetris game is running with initial default statistics
When the user selects the Game menu
And the user selects the Save Game button and enters "Test1234567"
Then the data file should be updated with the "initial" statistics
And the name should be "Test123456"


