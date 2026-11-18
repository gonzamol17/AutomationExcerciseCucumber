package stepsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.HeaderMenuPage;
import pageObject.HomePage;
import pageObject.LoginPage;

public class LoginSteps {
    private final HomePage hp;
    private final LoginPage lp;
    private final HeaderMenuPage hmp;

    public LoginSteps(HomePage hp, LoginPage lp,  HeaderMenuPage hmp) {
        this.hp = hp;
        this.lp = lp;
        this.hmp = hmp;
    }

    @When("ingresa el email {string}")
    public void ingresa_el_email(String email) {
       lp.setEmail(email);
    }

    @When("ingresa el password {string}")
    public void ingresa_el_password(String password) {
        lp.setPassword(password);
    }

    @When("presiona el botón Login")
    public void presiona_el_boton_login() {
        lp.clickLogin();
    }

    @Then("el usuario debe ver el mensaje {string}")
    public void el_usuario_debe_ver_el_mensaje(String expectedText) {
        Assert.assertTrue(
                hmp.getLoggedInAsText().contains(expectedText),
                "No se encontró el texto esperado: " + expectedText
        );
    }

    @Then("el usuario debe ver el mensaje de error {string}")
    public void el_usuario_debe_ver_el_mensaje_de_error(String expectedMessage) {

        Assert.assertEquals(
                lp.getErrorMessage(),
                expectedMessage,
                "El mensaje de error mostrado no es el esperado"
        );
    }
}
