package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends Base_PO{

    @FindBy(css = "a[href='/login']")
    WebElement signupLogin_Link;
    @FindBy(xpath = "//a[contains(normalize-space(),'Logged in as')]")
    private WebElement loggedInAs_Label;
    @FindBy(xpath = "//p[contains(normalize-space(),'Consentir')]")
    private WebElement btnConsentir;
    // Overlay que bloquea la pantalla
    @FindBy(css = "div.fc-dialog-overlay")
    private WebElement consentOverlay;


    public HomePage() {
        super();
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

    public void clickOnSignupLogin() {
        acceptCookiesIfPresent();
        waitForWebElementAndClick(signupLogin_Link);
    }

    public String getLoggedInAsText() {
        waitFor(loggedInAs_Label);
        return loggedInAs_Label.getText().trim();
    }
    
}
