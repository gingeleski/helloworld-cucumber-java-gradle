# Cucumber Project Setup

## Implementing a Feature File
- Create a Java class which addresses those "given, when, then" statements
- The start of each phrase is signified with "^"
- The end of each phrase is signified with "$"
- Regex is used to pass different test data
- Order of parameters depends on how they are passed from the Feature File

```
public class LoginTest
{
    @Given("^user navigates to SOFTWARETESTINGHELP.COM$")
    public void navigatePage() {
        System.out.println("Cucumber executed Given statement.");
    }

    @When("^user logs in using Username as \"(.*)\" and Password \"(.*)\"$")
    public void login(String username, String password) {
        System.out.println("Username is " + username);
        System.out.println("Password is " + password);
    }

    @When("^click the Submit button$")
    public void clickTheSubmitButton() {
        System.out.println("Executing When statement");
    }

    @Then("^Home page should be displayed$")
    public void validatePage() {
        System.out.println("Executing Then statement");
    }

    @Then("^login should be successful$")
    public void validateLoginSuccess() {
        System.out.println("Executing 2nd Then statement"); 
    }
}
```

## Order of execution
- When Cucumber finds a Given statement, the same Given statement is searched in the Java
- If it's found, Cucumber executes the function specified
- If it's not found, Cucumber will skip the step