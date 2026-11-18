package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchProductPage extends Base_PO{

    @FindBy(xpath = "//a[normalize-space()='View Product']")
    private WebElement viewProductOption;
    @FindBy(css = ".product-information h2")
    private WebElement titleProduct;
    @FindBy(css = "#dismiss-button-element > div")
    private WebElement closeModal;
    @FindBy(css = "div.productinfo.text-center > p")
    private List<WebElement> productNames;
    @FindBy(css = "div.productinfo.text-center")
    private List<WebElement> productCards;
    @FindBy(css = "div[class='productinfo text-center'] a[class='btn btn-default add-to-cart']")
    private WebElement addToCartBtn;
    @FindBy(xpath = "//button[normalize-space()='Continue Shopping']")
    private WebElement continueShoppingBtn;





    public SearchProductPage() {
        super();
    }

    public void selectViewProductOption(){
        waitForWebElementAndClick(viewProductOption);

    }

    public void scrollToViewProductOption() {
        scrollToElement(viewProductOption);
    }

    public String getTitleFromProductListed(){
        return waitForAndGetText(titleProduct);
    }

    public void selectViewProductFromList(String productName) {

        waitFor(productCards);

        for (WebElement card : productCards) {

            String name = card.findElement(By.tagName("p")).getText().trim();

            if (name.equalsIgnoreCase(productName)) {

                WebElement parent = card.findElement(
                        By.xpath("./ancestor::div[@class='product-image-wrapper']")
                );

                WebElement viewBtn = parent.findElement(
                        By.xpath(".//a[contains(@href,'product_details')]")
                );

                waitForWebElementAndClick(viewBtn);
                return;
            }
        }

        throw new RuntimeException("Producto no encontrado: " + productName);
    }

    public void selectAddToCartButton() throws InterruptedException {
        // Desplazamos el botón al centro de la pantalla
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].scrollIntoView({block: 'center', inline: 'nearest', behavior: 'instant'});",
                addToCartBtn
        );
        // Esperamos y hacemos clic
        waitForWebElementAndClick(addToCartBtn);

    }

    public boolean isContinueShoppingButtonDisplayed() {
        try {
            waitFor(continueShoppingBtn);
            return continueShoppingBtn.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public String getTitleFromContinueShoppingButton() throws InterruptedException {
        return waitForAndGetText(continueShoppingBtn);
    }





}
