package uk.ac.manchester.cs.comp33711.snakegame;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"},
				 features = "classpath:cucumber")
//                 features = "classpath:cucumber/snakeDirectionChange.feature")
//				   features = "classpath:cucumber/abilityToToggleTrees.feature")
public class RunSnakeGameTest {

}
