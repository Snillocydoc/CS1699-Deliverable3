Feature:
	As a Tetris player
	I want to exit the game via the Game menu
	In order to quit the application completely
	
Scenario: Exit application during running game from Game menu
Given a Tetris game is running
When the user selects the Game menu
And the user selects the "Exit" button
Then the application should exit

Scenario: Exit application during paused game from Game menu
Given a Tetris game is paused
When the user selects the Game menu
And the user selects the "Exit" button
Then the application should exit
	
	