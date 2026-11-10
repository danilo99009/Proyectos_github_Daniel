import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main{

    public static void main(String[] args){

        WebDriver dr = new EdgeDriver();
        WebDriverWait wt = new WebDriverWait(dr, Duration.ofSeconds(5));

        try{

            dr.get( "https://demoqa.com/text-box");
            dr.manage().window().maximize();
            WebElement nombre = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
            nombre.sendKeys("Laura Martínez");
            WebElement correo = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("userEmail")));
            correo.sendKeys("aura@gmail.com");

            WebElement submit = wt.until(ExpectedConditions.elementToBeClickable(By.id("submit")));

            JavascriptExecutor js = (JavascriptExecutor) dr;
            js.executeScript(
                    "arguments[0].scrollIntoView({block:'center'});",submit);

            submit.click();

            String nombreExtraido = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).getText();
            String correoExtraido = wt.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).getText();

            if(nombreExtraido.contains("Laura Martínez")){
                System.out.println("la prueba pasó el nombre es: "+ nombreExtraido);
            }

            if (correoExtraido.contains("aura@gmail.com")){
                System.out.println("el correo es: "+ correoExtraido);
            }

            else{

                IO.println("la prueba falló papi");
            }


        }catch(Exception e){

        }finally{
            dr.quit();
        }

    }

}
