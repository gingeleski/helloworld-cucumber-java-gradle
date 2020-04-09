
# Start a Cucumber project in IntelliJ

1. Open IntelliJ IDEA
2. "Create New Project"
3. Select Gradle, make sure just Java is checked
4. Put whatever for the GroupId (`com.gingeleski`) and ArtifactId (`cucumber-example`) fields
5. Make sure the following are all selected here
    - "Use auto-import"
    - "Create directories for empty content roots automatically"
    - "Create separate module per source set"
    - "Use default gradle wrapper"
6. Adjust the 'Project name' and 'Project location' if you need to

## Now that the project is set up

1. Open your `build.gradle` file
2. In the `dependencies` area, add the following lines after the existing `junit` entry
    - `testCompile group: 'info.cukes', name: 'cucumber-core', version: '1.1.7'`
    - `testCompile group: 'info.cukes', name: 'cucumber-java', version: '1.1.7'`
    - `testCompile group: 'info.cukes', name: 'cucumber-junit', version: '1.1.7'`
3. Save and close `build.gradle`
4. Create a new file `src/test/resources/sample.feature` and populate with the following

**sample.feature**

```
@SmokeTest
Feature: Cucumber run test

    I want to run a sample feature file.

Scenario: Cucumber setup

    Given sample feature file is ready
    When I run the feature file
    Then run should be successful
```

## Add parser steps

Create a new file `src/test/java/ParserSteps.java` and populate with the following

**ParserSteps.java**

```
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class ParserSteps
{
    @Given("^sample feature file is ready$")
    public void givenStatement() {
        System.out.println("Given statement executed successfully");
    }

    @When("^I run the feature file$")
    public void whenStatement(){
        System.out.println("When statement executed successfully");
    }

    @Then("^run should be successful$")
    public void thenStatement(){
        System.out.println("Then statement executed successfully");
    }
}
```

Note that we could've named this class *anything*.

## Add test runner

Create a new file `src/test/java/TestRunner.java` and populate with the following

```
import org.junit.runner.RunWith;

import cucumber.api.junit.*;

@RunWith(Cucumber.class)
public class TestRunner { }
```

And, demonstrating Cucumber options, we can then expand it into the following

```
import org.junit.runner.RunWith;

import cucumber.api.junit.*;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(format={"pretty",
        "html:build/test-results/test-report"},
        features={"src/test/resources"},
        tags={"@SmokeTest"})
public class TestRunner { }
```

## Running the test suite

1. Open Powershell
2. `cd` into the project directory (where the `build.gradle` file is)
3. `gradle test`
4. Now, in the same directory, observe test results in `build/test-results/test-report`
