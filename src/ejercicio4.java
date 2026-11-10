import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ejercicio4 {

    public static void main(String[] args) {

        WebDriver dr = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(10));

        try {
            dr.get("https://demoqa.com/buttons");
            dr.manage().window().maximize();

            WebElement boton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickBtn")));
            Actions acciones = new Actions(dr);
            acciones.doubleClick(boton).perform();


            String mensaje = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage"))).getText();
            System.out.println("El mensaje es: " + mensaje);


            if (mensaje.contains("You have done a double click")) {
                System.out.println("La prueba pasó :) ");
            } else {
                System.out.println("No pasó la prueba");
            }

        } catch (Exception e) {
        } finally {
            dr.quit();
        }
    }
}