Feature: 
	As a Tetris player
	I want to be able to pause the game
	In order to take a break and resume gameplay later

Scenario: Press pause during running game
Given a Tetris game is running
When the user selects the Game menu
And the user selects the "Pause" button
Then the running Tetris Game should pause

Scenario: Press pause during paused game
Given a Tetris game is paused
When the user selects the Game menu
And the user selects the "Pause" button
Then the paused Tetris game should continue

Scenario: Press pause without a game running or paused
Given a Tetris game is not running or paused
When the user selects the Game menu
And the user selects the "Pause" button
Then nothing should occur

Scenario: Controls are used when game is paused
Given a Tetris game is running
When the user selects the "Pause" button
And presses the up key
And presses the right key
Then nothing should occur

Scenario: User adds level
Given a Tetris game is running
When the user selects the "Increase Level" button
Then the level should increase by 1