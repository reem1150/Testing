package step_definition;

import Pages.P3_RestPassPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.BrowserUtils;

import java.util.concurrent.TimeUnit;

public class D3_RestPasswordStepDefinitions{

    P3_RestPassPage restPass = Hooks.PageBase.p3_restPassPagePOM();

    @Given("user clicks on forgot password")
    public void user_clicks_on_forgot_password()
    {
        // Press Forgot Password Button using POM
        restPass.restForgotPassButtonEle();
    }

    @When("user enters his valid email address")
    public void user_enters_his_email_address_to_reset_password()
    {
        Hooks.driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        // Enter valid email using POM
        restPass.restEmailEle(D1_RegistrationStepDefinition.email);
    }

    @And("user clicks on recover button")
    public void user_clicks_on_recover_button()
    {
        // Press Recover Button using POM
        restPass.restRecoverButtonEle();
    }

    @Then("user got a Displayed Message")
    public void got_a_Displayed_Message()
    {
        Hooks.driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        restPass.restAsserEle();
        // RestPassword Assertion using POM
        String expectedResult = "Email with instructions has been sent to you.";
        Assert.assertTrue(restPass.restAsserEle().contains(expectedResult), "Error Message: Display message doesn't exist");
        System.out.println("Recovery Message : Email with instructions has been sent to you.");
    }

    @And("user could close the Notification Bar")
    public void close_Notification_Bar() {
        // Close Notification Bar using POM
        restPass.restCloseBar();
        BrowserUtils.waitFor(5);

    }
}

