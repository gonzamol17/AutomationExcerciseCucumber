package stepsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.HeaderMenuPage;
import pageObject.HomePage;
import pageObject.LoginPage;

public class verifyThatTheSubscriptionWasSuccessfull {

    private final HomePage hp;
    private final LoginPage lp;
    private final HeaderMenuPage hmp;

    public verifyThatTheSubscriptionWasSuccessfull(HomePage hp, LoginPage lp, HeaderMenuPage hmp) {
        this.hp = hp;
        this.lp = lp;
        this.hmp = hmp;
    }

    @When("ingresa un email válido {string}")
    public void ingresaUnEmailValido(String email) throws InterruptedException {
        Thread.sleep(3000);
        hp.typeTheEmailOnSubscriptionBox(email);
        Thread.sleep(3000);
    }

    @When("hace clic en el botón Suscribirse")
    public void haceClicEnElBotonSuscribirse() throws InterruptedException {
        hp.clickOnSuscribeBtn();

    }

    @Then("se muestra un mensaje de confirmación con el texto {string} y en color verde")
    public void seMuestraUnMensajeDeConfirmacionConTextoYColorVerde(String textoEsperado) throws InterruptedException {
       Assert.assertEquals(textoEsperado, hp.showRedWarningSubscribe());
       Assert.assertEquals("rgba(60, 118, 61, 1)", hp.showTheColorOfRedWarningSubscribe());
       Thread.sleep(3000);
    }


}
