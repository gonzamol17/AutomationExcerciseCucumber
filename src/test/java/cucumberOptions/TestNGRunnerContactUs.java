package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"classpath:features"}
        ,glue={"stepsDefinitions"}, tags = "@smoke", plugin = {"pretty", "json:target/cucumber-reports/cucumber-report.json", "html:target/cucumber-reports/cucumber-html-report.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class TestNGRunnerContactUs extends AbstractTestNGCucumberTests {

    //con las lineas de código agregadas desde 14 a 18, lo único que hace es permitir ejecutar los test en paralelos
    //lo unico que hace que se ejecuten en paralelo es esto (parallel = true), si lo quito se ejecutan secuencial
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

