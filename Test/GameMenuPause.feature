Feature: Pause
	As a Tetris player
	I want to be able to pause the game
	In order to take a break and resume gameplay later

Scenario: Press pause during running game
Given a Tetris game is running with initial default statistics
When the user selects the Game menu
And the user selects the "Pause" button
Then the running Tetris game should pause

Scenario: Press pause during paused game
Given a Tetris game is running with initial default statistics
And a Tetris game is paused
When the user selects the Game menu
And the user selects the "Pause" button
Then the paused Tetris game should continue
