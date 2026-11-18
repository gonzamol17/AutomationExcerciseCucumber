package pageObject;

import Driver.DriveFactory;
import Utils.Global_Vars;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Base_PO {

    @FindBy(xpath = "//p[contains(normalize-space(),'Consentir')]")
    private WebElement btnConsentir;
    @FindBy(css = "div.fc-dialog-overlay")
    private WebElement consentOverlay;
    @FindBy(css = "div#dismiss-button[aria-label='Close ad']")
    private WebElement arrowCloseBottomBanner;




    public Base_PO() {
        PageFactory.initElements(getDriver(), this);
    }

    public WebDriver getDriver() {
        return DriveFactory.getDriver();
    }

    public void navigateTo_URL(String url) {
        getDriver().get(url);
        acceptCookiesIfPresent();
    }

    public void sendKeys(By by, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);

    }

    public void sendKeys(WebElement element, String textToType) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);

    }

    public void waitFor(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));

    }

    public void waitFor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));

    }


    public void waitForWebElementAndClick(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();

    }

    public void waitForWebElementAndClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    public String waitAlert_And_ValidateText() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.alertIsPresent());
        String alert_Message_Text = getDriver().switchTo().alert().getText();
        return alert_Message_Text;
    }

    public String waitForAndGetText(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText().trim();
    }

    private void acceptCookiesIfPresent() {
        try {
            if (btnConsentir.isDisplayed()) {
                waitForWebElementAndClick(btnConsentir);

                WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
                wait.until(ExpectedConditions.invisibilityOf(consentOverlay));
            }
        } catch (Exception e) {
            // Si el banner no aparece, seguimos
        }
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});",
                element
        );
        waitFor(element);
    }

    public void waitFor(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        for (WebElement element : elements) {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
    }

    public void scrollDown(int pixels) {
        ((JavascriptExecutor) getDriver())
                .executeScript("window.scrollBy(0," + pixels + ");");
    }

    public void handleGoogleVignette() {
        try {
            if (getDriver().getCurrentUrl().contains("google_vignette")) {
                getDriver().navigate().back(); // vuelve a la página real
            }
        } catch (Exception e) {
            // ignorar
        }
    }

    public void hoverOverElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(Global_Vars.DEFAULT_EXPLICIT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
    }





}
