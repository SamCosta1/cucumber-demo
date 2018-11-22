Feature: Record a personal high score for each player.

As a game administrator, I want each player's high score on the Snake Game to be
recorded, so that players have an incentive to play more often in order to beat their
high score.


Scenario: the high score for a player is unchanged when they end a game with a lower score.

Given a player with a high score of 2
When the player finishes a game with a score of 1
Then the player's new high score should be 2


Scenario: the high score for a player is updated when they end a game with a higher score.

Given a player with a high score of 1
When the player finishes a game with a score of 2
Then the player's new high score should be 2


Scenario: the high score for a player is unchanged when they end a game with exactly that score.

Given a player with a high score of 2
When the player finishes a game with a score of 2
Then the player's new high score should be 2

