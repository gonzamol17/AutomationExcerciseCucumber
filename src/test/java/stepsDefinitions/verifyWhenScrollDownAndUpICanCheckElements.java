package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.HeaderMenuPage;
import pageObject.HomePage;
import pageObject.LoginPage;

public class verifyWhenScrollDownAndUpICanCheckElements {

    private final HomePage hp;
    private final LoginPage lp;
    private final HeaderMenuPage hmp;

    public verifyWhenScrollDownAndUpICanCheckElements(HomePage hp, LoginPage lp, HeaderMenuPage hmp) {
        this.hp = hp;
        this.lp = lp;
        this.hmp = hmp;
    }

    @Then("el usuario debe ver visible el elemento {string} en el footer")
    public void elUsuarioDebeVerVisibleElElementoEnElFooter(String tituloBottom) throws InterruptedException {
        Assert.assertTrue(hp.getSubscriptionTitleDisplayed(tituloBottom));

    }

    @When("hace scroll up hasta el inicio de la página")
    public void haceScrollUpHastaElInicioDeLaPagina() throws InterruptedException {
        hp.scrollToHeaderHomeTitle();

    }

    @Then("el usuario debe ver visible el icono {string} con el título de la página")
    public void elUsuarioDebeVerVisibleElIconoConElTituloDeLaPagina(String homeTitle) throws InterruptedException {
        Assert.assertTrue(hp.getHeaderHomeTitleDisplayed(homeTitle));

    }
}
