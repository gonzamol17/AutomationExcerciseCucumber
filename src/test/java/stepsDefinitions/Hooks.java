package stepsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.ScreenshotUtil;

import static Driver.DriveFactory.cleanupDriver;
import static Driver.DriveFactory.getDriver;

public class Hooks {

        //public static WebDriver driver;
        private static final Logger log = LoggerFactory.getLogger(Hooks.class);

        @Before
        public void setUp() {
            /*System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\java\\utilities\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();*/
            getDriver();
            log.info("Driver iniciado");

        }


    @AfterStep
    public void takeScreenshotOnFailure(Scenario scenario) {
        ScreenshotUtil.captureExceptionImage(scenario);
    }



    @After() // Se ejecuta después: cierra driver
    public void tearDown(Scenario scenario) {
       cleanupDriver();
       log.info("Driver cerrado");
    }
}
