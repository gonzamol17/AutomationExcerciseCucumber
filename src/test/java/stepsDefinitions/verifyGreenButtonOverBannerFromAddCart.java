package stepsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.HeaderMenuPage;
import pageObject.ProductsPage;
import pageObject.SearchProductPage;


public class verifyGreenButtonOverBannerFromAddCart {

    private final HeaderMenuPage hmp;
    private final ProductsPage pp;
    private final SearchProductPage spp;

    public verifyGreenButtonOverBannerFromAddCart(HeaderMenuPage hmp, ProductsPage pp, SearchProductPage spp) {
        this.hmp = hmp;
        this.pp = pp;
        this.spp = spp;
    }

    @When("selecciona la opción Products")
    public void selecciona_la_opcion_products() {
        hmp.clickOnProducts();
    }

    @When("ingresa el nombre del producto {string} en el buscador y ejecuta la búsqueda")
    public void ingresa_el_nombre_del_producto_en_el_buscador_y_ejecuta_la_búsqueda(String productName) throws InterruptedException {
        pp.searchProduct(productName);

    }


    @When("selecciona Add to cart")
    public void selecciona_add_to_cart() throws InterruptedException {
        //productsPage.addProductToCart(productName);
        spp.selectAddToCartButton();

    }

    @Then("debe visualizar el botón {string} en el banner de confirmación")
    public void debe_visualizar_el_boton_en_el_banner_de_confirmacion(String expectedButtonText) throws InterruptedException {
        Assert.assertTrue(spp.isContinueShoppingButtonDisplayed(),
                "No se visualiza el botón Continue Shopping en el banner de confirmación");
        Assert.assertEquals(spp.getTitleFromContinueShoppingButton(), expectedButtonText,"El texto del botón no coincide con el esperado");
    }



}
