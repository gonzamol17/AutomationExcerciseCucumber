package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HeaderMenuPage extends Base_PO{

    @FindBy(css = ".navbar-nav>li")
    private List<WebElement> allItemsFromHeader;
    @FindBy(css = "a[href='/login']")
    private WebElement signupLogin_Link;
    @FindBy(xpath = "//a[contains(normalize-space(),'Logged in as')]")
    private WebElement loggedInAs_Label;
    @FindBy(xpath = " //a[contains(text(),'Test Cases')]")
    private WebElement testCasesOption;
    @FindBy(css = " a[href='/products']")
    private WebElement productsOption;
    @FindBy(css = "a[href='/logout']")
    private WebElement logoutOption;




    public HeaderMenuPage() {
        super();
    }

    public List<String> getAllItemsFromHeader() {
        List<String> titlesFromHeader = new ArrayList<>();
        for (WebElement item : allItemsFromHeader) {
            String text = item.getText().trim();
            titlesFromHeader.add(text);
        }
        return titlesFromHeader;
    }

    public void clickOnSignupLogin() {
        //acceptCookiesIfPresent();
        waitForWebElementAndClick(signupLogin_Link);
    }

    public String getLoggedInAsText() {
        waitFor(loggedInAs_Label);
        return loggedInAs_Label.getText().trim();
    }

    public void clickOnTestCases() {
        waitForWebElementAndClick(testCasesOption);
    }

    public void clickOnProducts() {
        waitForWebElementAndClick(productsOption);
        handleGoogleVignette();
        waitForWebElementAndClick(productsOption);
    }

    public void clickOnLogout() {
        waitForWebElementAndClick(logoutOption);
    }

}
