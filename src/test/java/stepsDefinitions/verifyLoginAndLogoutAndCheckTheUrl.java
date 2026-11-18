package stepsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.HeaderMenuPage;
import pageObject.HomePage;
import pageObject.LoginPage;

import java.util.List;
import java.util.Objects;

import static Driver.DriveFactory.getDriver;

public class verifyLoginAndLogoutAndCheckTheUrl {

    private final HeaderMenuPage hmp;


    public verifyLoginAndLogoutAndCheckTheUrl(HeaderMenuPage hmp) {
       this.hmp = hmp;
    }

    @When("presiona el botón Logout")
    public void presiona_el_botón_logout() {
        hmp.clickOnLogout();
    }

    @Then("el usuario debe estar en la url {string}")
    public void el_usuario_debe_estar_en_la_url(String url) {
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertNotNull(currentUrl);
        Assert.assertTrue(currentUrl.endsWith("/login"));
    }


}
