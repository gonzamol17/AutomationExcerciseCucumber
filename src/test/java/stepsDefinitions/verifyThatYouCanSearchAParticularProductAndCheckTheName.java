package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.HeaderMenuPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.ProductsPage;
import pageObject.SearchProductPage;

public class verifyThatYouCanSearchAParticularProductAndCheckTheName {

    private final HomePage hp;
    private final LoginPage lp;
    private final HeaderMenuPage hmp;
    private final ProductsPage ps;
    private final SearchProductPage spp;
    private String productName;

    public verifyThatYouCanSearchAParticularProductAndCheckTheName(HomePage hp, LoginPage lp, HeaderMenuPage hmp, ProductsPage ps,  SearchProductPage spp) {
        this.hp = hp;
        this.lp = lp;
        this.hmp = hmp;
        this.ps = ps;
        this.spp = spp;
    }

    @When("el usuario selecciona la opción {string} desde la Home Page")
    public void el_usuario_selecciona_la_opción_desde_la_home_page(String string) throws InterruptedException {
        hmp.clickOnProducts();
    }

    @And("el usuario ingresa el nombre de un producto existente en el buscador {string} y ejecuta la búsqueda")
    public void el_usuario_ingresa_el_nombre_de_un_producto_existente_en_el_buscador_y_ejecuta_la_búsqueda(String string) {
        this.productName = string;
        ps.searchProduct(string);
    }

    @And("el usuario selecciona la opción View Product del producto encontrado")
    public void el_usuario_selecciona_la_opción_del_producto_encontrado() throws InterruptedException {
        spp.scrollToViewProductOption();
        spp.selectViewProductOption();
        spp.handleGoogleVignette();
        spp.selectViewProductOption();

    }
    @Then("el nombre del producto en la página de detalles debe coincidir con el nombre buscado")
    public void el_nombre_del_producto_en_la_página_de_detalles_debe_coincidir_con_el_nombre_buscado() throws InterruptedException {
        String actual = spp.getTitleFromProductListed().trim();
        String expected = productName.trim();
        Assert.assertTrue(actual.equalsIgnoreCase(expected));

    }
}
