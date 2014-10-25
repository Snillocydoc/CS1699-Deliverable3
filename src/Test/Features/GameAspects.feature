Feature: Gameplay

Scenario: User exceeds allowable space
Given a Tetris game is running
When the user exceeds allowable space
Then the game should end

Scenario: User saves a piece
Given a Tetris game is running
When the user has a piece
And the user holds 
And the user drops 4 pieces
And the user restores the piece
Then the user should have the original piece

Scenario: Piece places when it reaches the bottom
Given a Tetris game is running
And the user presses down
Then the piece should be frozen

Scenario: Level up regularly in game
Given a Tetris game is running
And the score is 0
And the board is <X>
And the user places a long piece on the right side <x> times
Then the level should increase by 1