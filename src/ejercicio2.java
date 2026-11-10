import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ejercicio2 {

public static void main(String[] args){

    WebDriver dr = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(dr,Duration.ofSeconds(10));

    try {
        dr.get("https://demoqa.com/radio-button");
        dr.manage().window().maximize();

        WebElement radioI = wait.until(ExpectedConditions.elementToBeClickable(By.id("impressiveRadio")));
        if (!radioI.isSelected()) {
            radioI.click();
        }

       if( radioI.isSelected()) {

           WebElement alerta = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Impressive']")));

           String imp = alerta.getText();

           if (imp.contains("Impressive")) {
               System.out.println("el estado del boton es : " + imp);

           } else {

               IO.println("la prueba falló en el ultimo if");
           }
       }

    } catch(Exception e){

    }finally{
        dr.quit();
    }




  }


}
