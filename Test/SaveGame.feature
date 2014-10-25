Feature: Saved Games

Scenario: Saved game then restored
Given a Tetris game is running
When the game is saved
And the game is restored
Then the game should be the same as before

Scenario: Game is saved, then deleted
Given a Tetris game is running
When the game is saved
And the saved game is deleted
Then no saved game corresponding to this game should exist