package stepsDefinitions;

import Utils.Global_Vars;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObject.HomePage;


import static Driver.DriveFactory.getDriver;


public class LoginCommonSteps {
    private final WebDriver driver = getDriver();
    public final HomePage hp;
    private static final Logger log = LoggerFactory.getLogger(LoginCommonSteps.class);


    public LoginCommonSteps(HomePage hp) {
        this.hp = hp;
    }

    @Given("el usuario navega al home de Automation Exercise")
    public void navegar_al_home() {
        hp.navigateTo_URL(Global_Vars.HOMEPAGE_URL);
    }

    @When("accede a la opción Signup Login")
    public void accede_a_signup_login() {
        hp.clickOnSignupLogin();
    }




}
