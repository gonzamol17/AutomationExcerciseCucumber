package stepsDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import pageObject.HeaderMenuPage;
import pageObject.HomePage;
import pageObject.LoginPage;

import java.util.Arrays;
import java.util.List;

public class verifySubItemsFromCategorySection {

    private final HomePage hp;
    private final LoginPage lp;
    private final HeaderMenuPage hmp;
    private List<String> actualHeaderTitles;

    public verifySubItemsFromCategorySection(HomePage hp, LoginPage lp, HeaderMenuPage hmp) {
        this.hp = hp;
        this.lp = lp;
        this.hmp = hmp;
    }

    @When("el usuario expande la categoría {string}")
    public void usuario_expande_categoria(String category) throws InterruptedException {
        Thread.sleep(2000);
        hp.scrollDown(400);
        Thread.sleep(2000);
        hp.expandCategory(category);
        Thread.sleep(2000);
    }

    @Then("se deben visualizar las siguientes subcategorías {string}")
    public void se_visualizan_subcategorias(String subcategories) {
        // Convertir el string del feature a lista
        List<String> expectedSubcategories = Arrays.stream(subcategories.split(","))
                .map(String::trim)
                .toList();
        // Obtener lista real desde la UI
        List<String> actualSubcategories = hp.getVisibleSubcategories();
        System.out.println("Expected: " + expectedSubcategories);
        System.out.println("Actual: " + actualSubcategories);
        Assert.assertEquals(actualSubcategories, expectedSubcategories, "Las subcategorías no coinciden");
    }


}
