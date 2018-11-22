Feature: Control player's ability to toggle trees based on playing time.

As a game administrator, I want players' ability to toggle trees on and off between
games to depend on the amount of playing time they have accumulated, so that players
have an incentive to play for longer.


Scenario: Players with no accumulated playing time can't toggle trees.

Given a player with 0 seconds of playing time
When the player starts a game
Then trees will be switched off
 And the option to switch trees on or off is not available


Scenario: Players with just under 15 minutes accumulated playing time can't toggle trees.

Given a player with 14 minutes 59 seconds of playing time
When the player starts a game
Then trees will be switched off
 And the option to switch trees on or off is not available
 

Scenario: Players with just over 15 minutes of accumulated playing time can toggle trees.

Given a player with 15 minutes 0 seconds of playing time
When the player starts a game
Then trees will be switched off
 And the option to switch trees on or off is available


Scenario: Players with just under an hour of accumulated playing time can toggle trees.

Given a player with 59 minutes 59 seconds of playing time
When the player starts a game
Then trees will be switched off
 And the option to switch trees on or off is available


Scenario: Players with more than an hour of accumulated playing time can't toggle trees.

Given a player with 1 hour of playing time
When the player starts a game
Then trees will be switched on
 And the option to switch trees on or off is not available

  
