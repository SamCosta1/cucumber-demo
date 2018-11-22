Feature: Only perpendicular changes of snake direction are allowed.

As a game site owner, I want players to be able to change the snake's direction
at any point in an active game, so that Snake Game becomes a game of skill.


Scenario: a perpendicular direction change

Given a snake game in play
  And the snake is facing North
  And the player requests a change of direction to East
When the next game tick occurs
Then the snake's direction will become East


Scenario: another perpendicular direction change

Given a snake game in play
  And the snake is facing North
  And the player requests a change of direction to West
When the next game tick occurs
Then the snake's direction will become West


Scenario: a switch-back direction change

Given a snake game in play
  And the snake is facing North
  And the player requests a change of direction to South
When the next game tick occurs
Then the snake's direction will be unchanged


Scenario: a non-change direction change

Given a snake game in play
  And the snake is facing North
  And the player requests a change of direction to North
When the next game tick occurs
Then the snake's direction will be unchanged
