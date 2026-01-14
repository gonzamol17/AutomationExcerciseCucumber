package pageObject;

import Utils.Global_Vars;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Base_PO{

    @FindBy(css = "input[data-qa='login-email']")
    WebElement email_TextField;
    @FindBy(css = "input[data-qa='login-password']")
    WebElement password_TextField;
    @FindBy(css = "button[data-qa='login-button']")
    WebElement login_Button;
    @FindBy(xpath = "//p[normalize-space()='Your email or password is incorrect!']")
    WebElement redWrongLoginMsg;




    public LoginPage() {
        super();
    }

    public void setEmail(String email) {
        sendKeys(email_TextField, email);
    }

    public void setPassword(String password) {
        sendKeys(password_TextField, password);
    }

    public void clickLogin() {
        waitForWebElementAndClick(login_Button);
    }

    public String getErrorMessage() {
        return waitForAndGetText(redWrongLoginMsg);
    }




}
