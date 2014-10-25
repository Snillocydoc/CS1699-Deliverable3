Feature: 
	As a Tetris player
	I want to be able to jump levels
	In order to play at varying difficulties
	
#Note: The levels range from 1-15

Scenario: User adds level in interior range
Given a Tetris game is running
When the user selects the Game menu
And the user selects the "Jump Level" button
And the user enters 10
And the user selects "Ok"
Then the level should be 10

Scenario: User adds level at upper bound of range
Given a Tetris game is running
When the user selects the Game menu
And the user selects the "Jump Level" button
And the user enters 15
And the user selects "Ok"
Then the level should be 15

Scenario: User adds level at lower bound of range
Given a Tetris game is running
When the user selects the Game menu
And the user selects the "Jump Level" button
And the user enters 1
And the user selects "Ok"
Then the level should be 1

Scenario: User adds level lower than possible
Given a Tetris game is running
When the user selects the Game menu
And the user selects the "Jump Level" button
And the user enters 0
And the user selects "Ok"
Then the Enter Level window should reappear

Scenario: User adds level higher than possible
Given a Tetris game is running
When the user selects the Game menu
And the user selects the "Jump Level" button
And the user enters 16
And the user selects "Ok"
Then the Enter Level window should reappear

