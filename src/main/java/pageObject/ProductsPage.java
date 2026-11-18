package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends Base_PO{

    @FindBy(id = "search_product")
    private WebElement search_Box;
    @FindBy(xpath = "//button[@id='submit_search']")
    private WebElement iconToSearch;

    public ProductsPage() {
        super();
    }

    public void searchProduct(String productName) {
        sendKeys(search_Box, productName);
        waitForWebElementAndClick(iconToSearch);
    }



}
