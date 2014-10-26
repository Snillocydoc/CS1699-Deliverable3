Feature: Level Jump
	As a Tetris player
	I want to be able to jump levels
	In order to play at varying difficulties
	
#Note: The levels range from 1-15
#Note: Selecting the "Level Jump" button and entering the level number
		#had to be done in one step because the level needed to be set 
		#before the "Level Jump" button was pressed in order to function properly
		
Scenario: User adds level in interior range
Given a Tetris game is running with initial default statistics
When the user selects the Game menu
And the user selects the Level Jump button and enters 10
Then the level should be 10

Scenario: User adds level at upper bound of range
Given a Tetris game is running with initial default statistics
When the user selects the Game menu
And the user selects the Level Jump button and enters 15
Then the level should be 15

Scenario: User adds level at lower bound of range
Given a Tetris game is running with initial default statistics
When the user selects the Game menu
And the user selects the Level Jump button and enters 1
Then the level should be 1

Scenario: User adds level lower than possible
Given a Tetris game is running with initial default statistics
When the user selects the Game menu
And the user selects the Level Jump button and enters 0
Then the Enter Level window should reappear

Scenario: User adds level higher than possible
Given a Tetris game is running with initial default statistics
When the user selects the Game menu
And the user selects the Level Jump button and enters 16
Then the Enter Level window should reappear

