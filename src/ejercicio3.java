import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ejercicio3 {

    public static void main(String[] args) {
        WebDriver dr = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(5));

        try {
            dr.get(" https://www.selenium.dev/selenium/web/web-form.html");
            dr.manage().window().maximize();

            WebElement campoName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-text")));
            campoName.sendKeys("Prueba ADSO ");
            WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-password")));
            password.sendKeys("Sena2026");
            WebElement textoArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-textarea")));
            textoArea.sendKeys("Automatización con Selenium");

            WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type ='submit']")));
            submit.click();

            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), "Received!"));
            WebElement Recibido = dr.findElement(By.id("message"));
            String Tr = Recibido.getText();

            if (Tr.contains("Received!")) {
                IO.println("El texto recibido fue: " + Tr);
            } else {
                IO.println("no pasó la prueba");
            }


        } finally {
            dr.quit();
        }
    }
}
