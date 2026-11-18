package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class TestCasePage extends Base_PO{

    @FindBy(css = "body h4:nth-child(1) > a:nth-child(1) > u")
    private List<WebElement> allTestCasesList;



    public TestCasePage() {
        super();
    }

    public List<String> getAllTestCaseNames() {
        return allTestCasesList.stream()
                .map(e -> e.getText().trim())
                .collect(Collectors.toList());
    }

}
