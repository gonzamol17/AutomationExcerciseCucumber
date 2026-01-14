package utilities;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Driver.DriveFactory.getDriver;


public class ScreenshotUtil {

    public static void captureExceptionImage(Scenario scenario) {
        // Solo si falla el escenario
        if (!scenario.isFailed()) return;

        try {
            WebDriver driver = getDriver();

            // Crear carpeta si no existe
            String screenshotDir = "target/cucumber-reports/screenshots/";
            File dir = new File(screenshotDir);
            if (!dir.exists()) dir.mkdirs();

            // Nombre del archivo
            String screenshotName = scenario.getName()
                    .replaceAll("[^a-zA-Z0-9]", "_") + "_"
                    + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + ".png";

            File destFile = new File(screenshotDir + screenshotName);

            // Tomar screenshot y guardar
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Files.write(destFile.toPath(), screenshotBytes);

            // Adjuntar a Cucumber (opcional, útil si quieres ver en el reporte HTML de Cucumber)
            scenario.attach(screenshotBytes, "image/png", screenshotName);

            // **Adjuntar a Extent Reports** (ruta relativa a target/cucumber-reports)
            ExtentCucumberAdapter.addTestStepScreenCaptureFromPath("screenshots/" + screenshotName);

            System.out.println("✅ Screenshot capturado: " + screenshotName);

        } catch (Exception e) {
            System.err.println("❌ Error capturando screenshot: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
