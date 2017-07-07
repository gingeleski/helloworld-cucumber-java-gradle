# Basics of Cucumber

Starting with two example Feature Files...

## example1.feature
```
Feature: Login Functionality Feature

	In order to ensure Login Functionality works,
	I want to run the Cucumber test to verify it is working

Scenario: Login Functionality

	Given user navigates to SOFTWARETESTINGHELP.COM
	When user logins in using Username as "USER" and Password "PASSWORD"
	Then login should be successful

Scenario: Login Functionality

	Given user navigates to SOFTWARETESTINGHELP.COM
	When user logins in using Username as "USER" and Password "PASSWORD1"
	Then error message should be thrown
```

## example2.feature
```
Background:

    Given user logged in as databases administrator
    And all the junk values are cleared

Feature: Login Functionality Feature

Scenario: Login Functionality

    Given user navigates to SOFTWARETETINGHELP.COM
    When user logs in using Username as “USER”
    And password as “password”
    Then login should be successful
    And Home page should be displayed
```

## Feature Files
- End with .feature extension
- Essential to Cucumber
- Used to write test automation steps or acceptance tests
- Can be used as "live documents"
- The steps are the application spec

## Features
- The high-level business functionality and purpose of application under test
- Reading the first Feature should make the intent of the Feature File clear

## Scenarios
- A particular functionality under test
- Follows "given, when, then" format (Gherkin syntax)
    - **Given** specifies pre-conditions, it is a known state
    - **When** is used when some action is to be performed
    - **Then** is the expected outcome or result
    - **Background** is for any step required to perform each scenario, i.e. clear a database before each scenario
    - **And** is used to combine two or more actions of the same type

## Scenario Outlines
- Used when same test has to be performed with multiple sets of data
- Replace "Scenario" with "Scenario Outline"
- "Examples" are used to pass different arguments in tabular format

```
Feature: Login Functionality Feature

    In order to ensure Login Functionality works,
    I want to run the cucumber test to verify it is working

Scenario Outline:

    Given user navigates to SOFTWARETESTINGHELP.COM
    When user logs in using Username as <username> and Password <password>
    Then login should be successful

Examples:
    |username  |password   |
    |Tom       |password1  |
    |Harry     |password2  |
    |Jerry     |password3  |
```

## Tags

- By default Cucumber runs all scenarios in all feature files
- Specifying tags gives you something to filter by so as not to run hundreds of feature files at all times
- Tags can be at the Feature level or Scenario level

```
@SmokeTest @LoginTest

Feature: Login Functionality Feature

    In order to ensure Login Functionality works,
    I want to run the cucumber test to verify it is working

Scenario Outline: Login Functionality

...

@positiveScenario
Scenario: Login Functionality

...
```

## JUnit Runner

- Cucumber uses a standard JUnit runner
- Tags get specified in @Cucumber.Options
- Multiple tags get specified with commas as delimiters
- Can also specify the path and type of report

```
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(format={"SimpleHtmlReport:report/smokeTest.html"}, tags={"@SmokeTest"})
Public class JUnitRunner { ... }
```

## Cucumber Reporting
- By default this is generated in Cucumber's own HTML format
- Better reporting can be done, for example using Jenkins or Bamboo