package fr.kata.order.bdd;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"pretty", "html:target/cucumber-reports"},
        glue = {"fr.kata.order.bdd"}
)
public class CucumberRunnerTest {
}
