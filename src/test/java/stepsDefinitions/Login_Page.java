package stepsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.LoginPage;

import static Driver.DriveFactory.getDriver;


public class Login_Page {
 /*   //WebDriver driver = Hooks.driver;
    private final WebDriver driver = getDriver();
    private final Login_PO login_po;


    public Login_Page(Login_PO login_po) {
        this.login_po = login_po;

    }


    *//*@Given("I access the webdriver university home page")
    public void i_access_the_webdriver_university_home_page() throws InterruptedException {
        //navigateTo_URL("https://webdriveruniversity.com");
        login_po.navigateTo_Webdriver_Login_Page();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 800);"); // scroll 500 píxeles hacia abajo
        Thread.sleep(2000);

    }*//*

   *//* @When("I enter to the login section")
    public void i_enter_to_the_login_section() throws InterruptedException {
        driver.findElement(By.xpath("//h1[normalize-space()='LOGIN PORTAL']")).click();
        Thread.sleep(2000);
        String originalWindow = driver.getWindowHandle();

        // Esperar nueva pestaña
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.getWindowHandles().size() > 1);

        // Cambiar a la nueva pestaña
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }*//*

    @When("I enter a {string} username")
    public void i_enter_a_valid_username(String name) throws InterruptedException {
        
        //driver.findElement(By.cssSelector("input#text")).sendKeys(name);
        login_po.setUsername(name);

    }

    @When("I enter a {string} password")
    public void i_enter_a_valid_password(String password) throws InterruptedException {

        //driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        login_po.setPassword(password);

    }

    *//*@When("I select the submit button")
    public void i_select_the_submit_button() throws InterruptedException {
        //Thread.sleep(2000);
        //driver.findElement(By.id("login-button")).click();
        login_po.clickOn_Login_Button();

    }*//*

    @Then("I should be presented a pop up with the {string} login")
    public void i_should_be_presented_a_pop_up_with_the_Message_login(String result) {
        //Alert alert = driver.switchTo().alert();
        //String alertText = alert.getText();
        //alert.accept();
        Assert.assertEquals(login_po.validate_Login_Message(), "validation "+result);
    }
*/
}
