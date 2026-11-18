package pageObject;

import Utils.Global_Vars;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HomePage extends Base_PO{

    @FindBy(xpath = "//p[contains(normalize-space(),'Consentir')]")
    private WebElement btnConsentir;
    // Overlay que bloquea la pantalla
    @FindBy(css = "div.fc-dialog-overlay")
    private WebElement consentOverlay;
    @FindBy(xpath = "//h2[normalize-space()='Subscription']")
    private WebElement subscriptionTitle;
    @FindBy(css = "img[alt='Website for automation practice']")
    private WebElement automatorExerciseTitle;
    @FindBy(id = "susbscribe_email")
    private WebElement txtSubcriptionEmail;
    @FindBy(id = "subscribe")
    private WebElement btnSuscribe;
    @FindBy(css = "div.alert-success.alert")
    private WebElement redSuccessWarningSubscribe;
    @FindBy(css = "body div.productinfo.text-center > p")
    private List<WebElement> allTitlesProductsFromHome;
    @FindBy(css = "ul.nav.nav-pills.nav-stacked>li>a")
    private List<WebElement> allBrandTitlesProductsFromHome;
    @FindBy(xpath = "//div[contains(@class,'choose')]//a")
    private List<WebElement> viewAllProductDetail;
    @FindBy(css = "#dismiss-button > div > span")
    private WebElement closeModal;
    private String foundProductName;





    public HomePage() {
        super();
    }

    /*private void acceptCookiesIfPresent() {
        try {
            if (btnConsentir.isDisplayed()) {
                waitForWebElementAndClick(btnConsentir);

                WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
                wait.until(ExpectedConditions.invisibilityOf(consentOverlay));
            }
        } catch (Exception e) {
            // Si el banner no aparece, seguimos
        }
    }*/

    public boolean getSubscriptionTitleDisplayed(String expectedText) {
        waitFor(subscriptionTitle);
        return subscriptionTitle.isDisplayed()
                && subscriptionTitle.getText().equalsIgnoreCase(expectedText);
    }

    public void scrollToFooterSubscriptionTitle() {
        scrollToElement(subscriptionTitle);
    }

    public void scrollToHeaderHomeTitle() {
        scrollToElement(automatorExerciseTitle);
    }

    public boolean getHeaderHomeTitleDisplayed(String expectedText) {
        waitFor(automatorExerciseTitle);
        String altText = automatorExerciseTitle.getDomAttribute("alt");
        return automatorExerciseTitle.isDisplayed()
                && expectedText.equalsIgnoreCase(altText);

    }

    public void typeTheEmailOnSubscriptionBox(String email) {
        txtSubcriptionEmail.sendKeys(email);
    }

    public void clickOnSuscribeBtn() {
        btnSuscribe.click();
    }

    public String showRedWarningSubscribe() {
        return redSuccessWarningSubscribe.getText();
    }

    public String showTheColorOfRedWarningSubscribe() {
        waitFor(redSuccessWarningSubscribe);
        return redSuccessWarningSubscribe.getCssValue("color");
    }

    public List<String> getAllTitlesFromHome() {
        waitFor(allTitlesProductsFromHome);
        List<String> titlesFromHome = new ArrayList<>();
        for (WebElement item : allTitlesProductsFromHome) {
            String text = item.getText();
            titlesFromHome.add(text);
            System.out.println(text);
        }
        return titlesFromHome;
    }

    public int getTotalProductsFromHomePage() {
        waitFor(allTitlesProductsFromHome); // espera lista completa
        return allTitlesProductsFromHome.size();
    }

    private String capitalize(String text) {
        return text.substring(0,1).toUpperCase() +
                text.substring(1).toLowerCase();
    }

    public void expandCategory(String category) {

        String xpath = "//a[normalize-space()='" + capitalize(category) + "']";
        WebElement categoryElement = getDriver().findElement(By.xpath(xpath));
        scrollToElement(categoryElement);
        categoryElement.click();
    }

    public List<String> getVisibleSubcategories() {

        String subCategoryXpath = "//div[@class='panel-body']//a";

        List<WebElement> elements = getDriver().findElements(By.xpath(subCategoryXpath));

        List<String> subcategories = new ArrayList<>();

        for (WebElement el : elements) {
            if (el.isDisplayed()) {
                subcategories.add(el.getText().trim());
            }
        }

        return subcategories;
    }

    public void debugScrollDown() {
        scrollDown(1500);
    }


    public Map<String, Integer> obtenerMarcasYCantidades() {
        Map<String, Integer> marcasMap = new LinkedHashMap<>();
        for (WebElement link : allBrandTitlesProductsFromHome) {
            WebElement spanCantidad = link.findElement(By.tagName("span"));
            String cantidadTexto = spanCantidad.getText()
                    .replace("(", "")
                    .replace(")", "")
                    .trim();
            int cantidad = Integer.parseInt(cantidadTexto);
            String nombre = link.getText()
                    .replace(spanCantidad.getText(), "")
                    .trim();
            marcasMap.put(nombre, cantidad);
        }
        return marcasMap;
    }

    public boolean searchAParticularProduct(String product) throws InterruptedException {
        waitFor(allTitlesProductsFromHome);
        for (int i = 0; i < allTitlesProductsFromHome.size(); i++) {
            WebElement item = allTitlesProductsFromHome.get(i);
            try {
                scrollToElement(item);
            } catch (org.openqa.selenium.TimeoutException e) {//no hacemos nada
                }
            if (item.getText().equalsIgnoreCase(product)) {
                foundProductName = item.getText();
                System.out.println("Encontré el producto "+item.getText());
                return true;
            }
        }
        System.out.println("No se encontró el producto: " + product);
        return false;
    }

    public String getFoundProductName() {
        return foundProductName;
    }






}
