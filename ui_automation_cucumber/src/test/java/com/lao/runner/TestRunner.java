package com.lao.runner;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/resources/Featurefiles",
		glue = {"com.lao.step_definitions"},
		dryRun = false,
		monochrome = true,
        plugin = {"rerun:target/failed_scenarios.txt"}
		)
public class TestRunner {

}
