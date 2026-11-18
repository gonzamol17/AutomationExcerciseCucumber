package stepsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.HeaderMenuPage;
import pageObject.HomePage;
import pageObject.LoginPage;

import java.util.Arrays;
import java.util.List;

public class verifyThatWeCanSearchAndViewDetailProductFromHomePage {

    private final HomePage hp;
    private final LoginPage lp;
    private final HeaderMenuPage hmp;

    public verifyThatWeCanSearchAndViewDetailProductFromHomePage(HomePage hp, LoginPage lp, HeaderMenuPage hmp) {
        this.hp = hp;
        this.lp = lp;
        this.hmp = hmp;
    }

    @When("abre el detalle del producto {string}")
    public void abre_detalle_producto(String producto) throws InterruptedException {
        boolean isFoundProduct = hp.searchAParticularProduct(producto);
        Assert.assertTrue(isFoundProduct);
    }

    @Then("el nombre del producto mostrado debe ser {string}")
    public void nombre_product_mostrado(String producto) {
        Assert.assertEquals(hp.getFoundProductName(), producto);

    }

}
