package Driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class DriveFactory {

    private static final ThreadLocal<WebDriver> webdriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (webdriver.get() == null) {
            webdriver.set(createDriver());
        }
        return webdriver.get();
    }

    private static WebDriver createDriver() {
        WebDriver driver;

        switch (getBrowserType()) {
            case "firefox":
                FirefoxOptions ffOpt = new FirefoxOptions();
                ffOpt.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(ffOpt);
                break;

            default:
                ChromeOptions chOpt = new ChromeOptions();
                chOpt.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chOpt);
                break;
        }

        driver.manage().window().maximize();
        return driver;
    }

    private static String getBrowserType() {
        String browserFromCLI = System.getProperty("browserType");

        if (browserFromCLI != null && !browserFromCLI.isEmpty()) {
            return browserFromCLI.toLowerCase();
        }

        // Lectura segura y multiplataforma del config.properties
        try {
            Properties prop = new Properties();
            String configPath = Paths.get("src", "main", "java", "Properties", "config.properties").toString();
            prop.load(new FileInputStream(configPath));
            return prop.getProperty("browser", "chrome").toLowerCase().trim();

        } catch (IOException e) {
            System.err.println("No se pudo leer config.properties. Usando Chrome.");
            return "chrome";
        }
    }

    public static void cleanupDriver() {
        if (webdriver.get() != null) {
            webdriver.get().quit();
            webdriver.remove();
        }
    }

}

