package stepsDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.*;

import java.util.Map;

public class verifyTheReviewForAProductIsCheckedWithSuccess {

    private final SearchProductPage spp;
    private final HeaderMenuPage hmp;
    private final ProductsPage pp;
    private final ProductDetailPage pdp;



    public verifyTheReviewForAProductIsCheckedWithSuccess (SearchProductPage spp, HeaderMenuPage hmp, ProductsPage pp, ProductDetailPage pdp) {
        this.spp = spp;
        this.hmp = hmp;
        this.pp = pp;
        this.pdp = pdp;


    }


    @When("el usuario selecciona la opción Products")
    public void elUsuarioSeleccionaLaOpcionProducts() {
       hmp.clickOnProducts();

    }


    @And("busca el producto {string}")
    public void elUsuarioBuscaElProducto(String productName) {
        pp.searchProduct(productName);

    }

    @And("selecciona la opción de View Detail Page del producto")
    public void selecciona_la_opción_de_view_detail_page_del_producto() throws InterruptedException {
        spp.scrollToViewProductOption();
        Thread.sleep(1000);
        spp.selectViewProductOption();

    }


    @And("en el detalle de la pagina del producto completa los campos de la review y lo envía:")
    public void completaLosCamposDeLaReview(DataTable dataTable) throws InterruptedException {
        pdp.scrollToSubmitButton();
        Thread.sleep(1000);
        Map<String, String> reviewData = dataTable.asMap(String.class, String.class);
        pdp.completeTheReviewForm(
                reviewData.get("name"),
                reviewData.get("email"),
                reviewData.get("review")
        );
        Thread.sleep(1000);

    }


    @Then("el usuario tiene que visualizar la confirmación de la review con el mensaje {string}")
    public void verificaMensajeConfirmacionReview(String expectedMessage) {
        String actualMessage = pdp.getSuccessMessageReviewed();
        Assert.assertEquals(actualMessage, expectedMessage, "El mensaje de confirmación de la review no coincide");
    }


}
