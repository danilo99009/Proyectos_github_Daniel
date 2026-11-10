import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class ejercicio6 {

    public static void main(String[] args) {

        WebDriver dr = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));

        try {
            dr.get("https://www.selenium.dev/selenium/web/dynamic.html");
            dr.manage().window().maximize();

            wait.until(ExpectedConditions.elementToBeClickable(By.id("reveal"))).click();
            WebElement campo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("revealed")));
            String texto = "Prueba Selenium ADSO";
            campo.sendKeys(texto);

            String valor = campo.getDomProperty("value");
            System.out.println("Valor del campo: " + valor);

            if (valor.equals(texto)) {
                System.out.println("La prueba pasó: el texto es correcto");
            } else {
                System.out.println("No pasó la prueba");
            }

            File origen = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
            File destino = new File("evidencia_selenium.png");
            FileHandler.copy(origen, destino);
            System.out.println("Captura guardada en: " + destino.getAbsolutePath());

        } catch (Exception e) {
        } finally {
            dr.quit();
        }
    }
}