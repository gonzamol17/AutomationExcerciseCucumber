package stepsDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.HeaderMenuPage;
import pageObject.HomePage;
import pageObject.LoginPage;

import java.util.List;

public class verifyItemsFromHeader {
    private final HomePage hp;
    private final LoginPage lp;
    private final HeaderMenuPage hmp;
    private List<String> actualHeaderTitles;

    public verifyItemsFromHeader(HomePage hp, LoginPage lp, HeaderMenuPage hmp) {
        this.hp = hp;
        this.lp = lp;
        this.hmp = hmp;
    }

    @When("captura todas las opciones disponibles en el header")
    public void captura_todas_las_opciones_disponibles_en_el_header() {
       actualHeaderTitles  = hmp.getAllItemsFromHeader();

    }

    @Then("el header debe mostrar las siguientes opciones:")
    public void el_header_debe_mostrar_las_siguientes_opciones(DataTable dataTable) {
        //Convertimos la tabla del feature a List<String>
        List<String> expectedHeaderTitles = dataTable.asList(String.class);
        System.out.println("Header esperado: " + expectedHeaderTitles);
        Assert.assertEquals(actualHeaderTitles, expectedHeaderTitles,"Las opciones del header no coinciden con las esperadas");
    }



}
