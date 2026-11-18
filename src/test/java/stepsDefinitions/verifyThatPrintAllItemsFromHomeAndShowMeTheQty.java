package stepsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.HeaderMenuPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.TestCasePage;

public class verifyThatPrintAllItemsFromHomeAndShowMeTheQty {

    private final HomePage hp;


    public verifyThatPrintAllItemsFromHomeAndShowMeTheQty(HomePage hp) {
        this.hp = hp;

    }

    @When("imprime la lista de productos visibles en el Home Page")
    public void obtenerListaDeProductos() {
        hp.getAllTitlesFromHome();
    }

    @Then("el número de productos debe ser igual a {int}")
    public void verificarCantidadExactaDeProductos(int cantidadEsperada) {
        int totalProductos = hp.getTotalProductsFromHomePage();
        Assert.assertEquals(cantidadEsperada, totalProductos);
    }


}
