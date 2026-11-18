package stepsDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.HeaderMenuPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.TestCasePage;

import java.util.List;

public class verifyIfAParicularTestIsPresentFromTestCasesList {

    private final HomePage hp;
    private final LoginPage lp;
    private final HeaderMenuPage hmp;
    private final TestCasePage tcp;

    public verifyIfAParicularTestIsPresentFromTestCasesList(HomePage hp, LoginPage lp, HeaderMenuPage hmp, TestCasePage tcp) {
        this.hp = hp;
        this.lp = lp;
        this.hmp = hmp;
        this.tcp = tcp;
    }

    @When("el usuario ingresa a la opción Test Cases")
    public void elUsuarioIngresaALaOpcionTestCases() {
        hmp.clickOnTestCases();
    }

    @Then("el usuario debe ver los siguientes test cases listados:")
    public void elUsuarioDebeVerLosSiguientesTestCasesListados(DataTable dataTable) {

        // Test cases esperados desde el feature
        List<String> expectedTestCases = dataTable.asList(String.class);

        // Test cases reales desde la UI
        List<String> actualTestCases = tcp.getAllTestCaseNames();

        // Buscar cuáles faltan
        List<String> missingTestCases = expectedTestCases.stream()
                .filter(expected -> !actualTestCases.contains(expected))
                .toList();

        // Assert final
        Assert.assertTrue(missingTestCases.isEmpty(),"Los siguientes Test Cases NO fueron encontrados en la lista: " + missingTestCases);
    }


}
