Feature: New Game
	As a Tetris player
	I want to be able to start a new game
	In order to begin a brand new game with the initial default statistics
	
Scenario: Start new game during running game
Given a Tetris game is running with initial default statistics
When the user selects the Game menu
And the user selects the "New Game" button
Then a new game with the initial default statistics should begin

Scenario: Start new game during paused game
Given a Tetris game is paused
When the user selects the Game menu
And the user selects the "New Game" button
Then a new game with the initial default statistics should begin

Scenario: Start new game from changed statistics
Given a Tetris game is running with initial default statistics
When the user selects the Game menu
And the user selects the "New Game" button
Then a new game with the initial default statistics should begin
