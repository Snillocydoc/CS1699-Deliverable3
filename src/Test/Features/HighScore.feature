Feature: High Score

Scenario: New high score
Given a Tetris game is running
And a score of 10000 is achieved
When the game ends
Then a new high score should be recorded

Scenario: Score not worthy of new high score record is obtained
Given a Tetris game is running
And a score of 1 is achieved
When the game ends
Then a new high score should NOT be recorded

Scenario: Delete high scores
Given there are high scores recorded
When the high scores are cleared
Then no high scores should exist