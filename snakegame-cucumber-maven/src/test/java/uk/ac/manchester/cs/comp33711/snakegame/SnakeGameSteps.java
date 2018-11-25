package uk.ac.manchester.cs.comp33711.snakegame;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class SnakeGameSteps {

    private SnakeGame snakeGame;
    private String originalDirection;

    @Given("^a snake game in play$")
    public void a_snake_game_in_play() throws Throwable {
        snakeGame = new SnakeGame();
        snakeGame.play();
    }

    @Given("^the snake is facing (\\w+)")
    public void the_snake_is_facing_North(String direction) throws Throwable {
        originalDirection = direction;
        snakeGame.setSnakeDirection("North");
    }

    @Given("^the player requests a change of direction to (\\w+)")
    public void the_player_requests_a_change_of_direction(String direction) throws Throwable {
        snakeGame.setSnakeDirection(direction);
    }

    @When("^the next game tick occurs$")
    public void the_next_game_tick_occurs() throws Throwable {
        snakeGame.tick();
    }

    @Then("^the snake's direction will become (\\w+)")
    public void the_snake_s_direction_will_become_West(String direction) throws Throwable {
        assertEquals(direction, snakeGame.getDirection());
    }

    @Then("^the snake's direction will be unchanged$")
    public void the_snake_s_direction_will_be_unchanged() throws Throwable {
        assertEquals(originalDirection, snakeGame.getDirection());
    }


    @Given("^a player with (\\d+) seconds of playing time$")
    public void aPlayerWithSecondsOfPlayingTime(int time) throws Throwable {
        snakeGame = new SnakeGame();
        snakeGame.setTimeSeconds(time);
    }

    @When("^the player starts a game$")
    public void thePlayerStartsAGame() throws Throwable {
        snakeGame.play();
    }

    @Then("^trees will be switched off$")
    public void treesWillBeSwitchedOff() throws Throwable {
        assertFalse(snakeGame.areTreesEnabled());
    }

    @And("^the option to switch trees on or off is not available$")
    public void theOptionToSwitchTreesOnOrOffIsNotAvailable() throws Throwable {
        assertFalse(snakeGame.isTreeTogglingEnabled());
    }

    @Given("^a player with (\\d+) minutes (\\d+) seconds of playing time$")
    public void aPlayerWithMinutesSecondsOfPlayingTime(int minutes, int seconds) throws Throwable {
        snakeGame = new SnakeGame();
        snakeGame.setTimeSeconds(minutes * 60 + seconds);
    }

    @And("^the option to switch trees on or off is available$")
    public void theOptionToSwitchTreesOnOrOffIsAvailable() throws Throwable {
        assertTrue(snakeGame.isTreeTogglingEnabled());
    }

    @Given("^a player with (\\d+) hour of playing time$")
    public void aPlayerWithHourOfPlayingTime(int hours) throws Throwable {
        snakeGame = new SnakeGame();

        snakeGame.setTimeSeconds(hours * 60 * 60);
    }

    @Then("^trees will be switched on$")
    public void treesWillBeSwitchedOn() throws Throwable {
        assertTrue(snakeGame.areTreesEnabled());
    }

}
