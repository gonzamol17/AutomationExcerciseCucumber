package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends Base_PO{

    @FindBy(id = "button-review")
    private WebElement btn_Submit;
    @FindBy(id = "name")
    private WebElement text_Name;
    @FindBy(id = "email")
    private WebElement txt_email;
    @FindBy(id = "review")
    private WebElement txt_review;
    @FindBy(css = "div[class='alert-success alert'] span")
    private WebElement successMessageReviewed;





    public ProductDetailPage() {
        super();
    }

    public void scrollToSubmitButton() {
        scrollToElement(btn_Submit);
    }

    public void completeTheReviewForm(String name, String email, String review){
        sendKeys(text_Name, name);
        sendKeys(txt_email, email);
        sendKeys(txt_review, review);
        waitForWebElementAndClick(btn_Submit);
    }

    public String getSuccessMessageReviewed() {
        return successMessageReviewed.getText();
    }



}





