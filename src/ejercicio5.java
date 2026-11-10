import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class ejercicio5 {

        public static void main(String[] args) {

            WebDriver dr = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));

            try {
                dr.get("https://demoqa.com/webtables");
                dr.manage().window().maximize();

                wait.until(ExpectedConditions.elementToBeClickable(By.id("addNewRecordButton"))).click();

                WebElement nombre = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
                nombre.sendKeys("Carlos");

                dr.findElement(By.id("lastName")).sendKeys("Ramírez");
                dr.findElement(By.id("userEmail")).sendKeys("carlos@gmail.com");
                dr.findElement(By.id("age")).sendKeys("25");
                dr.findElement(By.id("salary")).sendKeys("2500000");
                dr.findElement(By.id("department")).sendKeys("Sistemas");
                dr.findElement(By.id("submit")).click();

                wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".rt-tbody"), "Carlos"));

                WebElement buscador = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBox")));
                buscador.sendKeys("Carlos");

                boolean encontrado = wait.until(ExpectedConditions.textToBePresentInElementLocated(
                        By.cssSelector(".rt-tbody"), "Ramírez"));

                String tabla = dr.findElement(By.cssSelector(".rt-tbody")).getText();
                System.out.println("Contenido de la tabla:" + tabla);

                if (encontrado && tabla.contains("Carlos") && tabla.contains("Ramírez")) {
                    System.out.println("La prueba pasó");
                } else {
                    System.out.println("No pasó la prueba");
                }

            } catch (Exception e) {

            } finally {
                dr.quit();
            }
        }
    }



