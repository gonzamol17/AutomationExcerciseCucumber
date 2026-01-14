package stepsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.LoginPage;

import static Driver.DriveFactory.getDriver;


public class Login_Page_Outline {
/*
    //WebDriver driver = Hooks.driver;
    private final WebDriver driver = getDriver();

    private Login_PO login_po;


    public Login_Page_Outline(Login_PO login_po) {
        this.login_po = login_po;

    }

    *//*@Given("I access the webdriver university home")
    public void i_access_the_webdriver_university_home() throws InterruptedException {
        //navigateTo_URL("https://webdriveruniversity.com");
        login_po.navigateTo_Webdriver_Login_Page();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 500);"); // scroll 500 píxeles hacia abajo
        Thread.sleep(2000);

    }*//*

    *//*@When("I enter to the login sectionn")
    public void i_enter_to_the_login_sectionn() throws InterruptedException {
        driver.findElement(By.cssSelector("a[id='login-portal'] h1")).click();
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

    @When("I enter a unique username {word}")
    public void i_enter_a_unique_username_webdriver(String username) {
        //driver.findElement(By.cssSelector("input#text")).sendKeys(username);
        login_po.setUsername(username);
    }
    @When("I enter a unique password {word}")
    public void i_enter_a_unique_password_webdriver123(String  password) {
        //driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        login_po.setPassword(password);
    }

   *//* @When("I select the submit buttonn")
    public void i_select_the_submit_buttonn() throws InterruptedException {
        //driver.findElement(By.id("login-button")).click();
        login_po.clickOn_Login_Button();

    }*//*

    @Then("I should be presented a pop up with the following message {}")
    public void i_should_be_presented_a_pop_up_with_the_following_message(String  message) {
        //Alert alert = driver.switchTo().alert();
        //String alertText = alert.getText();
        //alert.accept();
        //Assert.assertEquals(alertText, message);
        Assert.assertEquals(login_po.validate_Login_Message(), message);
    }*/
}
