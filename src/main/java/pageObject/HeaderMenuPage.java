package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HeaderMenuPage extends Base_PO{

    @FindBy(css = ".navbar-nav>li")
    List<WebElement> allItemsFromHeader;


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

}
