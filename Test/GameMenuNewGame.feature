Feature:
	As a Tetris player
	I want to be able to start a new game
	In order to start a brand new game
	
Scenario: Start new game during running game
Given a Tetris game is running
When the user selects the Game menu
And the user selects the "New Game" button
Then a new game should begin

Scenario: Start new game during paused game
Given a Tetris game is paused
When the user selects the Game menu
And the user selects the "New Game" button
Then a new game should begin

Scenario: Start new game from changed level
Given a Tetris game is running with a level greater than 1
When the user selects the Game menu
And the user selects the "New Game" button
Then a new game should begin
