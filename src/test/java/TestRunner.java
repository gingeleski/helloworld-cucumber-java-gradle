import org.junit.runner.RunWith;

import cucumber.api.junit.*;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(format={"pretty",
        "html:build/test-results/test-report"},
        features={"src/test/resources"},
        tags={"@SmokeTest"})
public class TestRunner { }
