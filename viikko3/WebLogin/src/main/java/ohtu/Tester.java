package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;

public class Tester {

    public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver", "D:/Koulujuttui/chromedriver.exe"); 
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
  //       oikea käyttäjätunnus väärä salasana

  //       WebElement element = driver.findElement(By.linkText("login"));
  //       element.click();

  //       sleep(2);

  //       element = driver.findElement(By.name("username"));
  //       element.sendKeys("pekka");
  //       element = driver.findElement(By.name("password"));
  //       element.sendKeys("väärä");
  //       element = driver.findElement(By.name("login"));
        
  //       sleep(2);
  //       element.submit();

  //       sleep(3);
  //       WebElement element = driver.findElement(By.linkText("register new user"));
  //       element.click();
  //       sleep(2);

  //       Random r = new Random();
    
		// element = driver.findElement(By.name("username"));
		// element.sendKeys("joonas"+r.nextInt(100000));

  //       element = driver.findElement(By.name("password"));
  //       element.sendKeys("salasana");

  //       element = driver.findElement(By.name("passwordConfirmation"));
  //       element.sendKeys("salasana");

  //       element = driver.findElement(By.name("signup"));
  //       sleep(2);

  //       element.click();

        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();
        sleep(2);

        Random r = new Random();
    
		element = driver.findElement(By.name("username"));
		element.sendKeys("joonas"+r.nextInt(100000));

        element = driver.findElement(By.name("password"));
        element.sendKeys("salasana");

        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("salasana");

        element = driver.findElement(By.name("signup"));
        sleep(2);

        element.click();

        element = driver.findElement(By.linkText("continue to application mainpage"));
        sleep(2);
        element.click();
        element = driver.findElement(By.linkText("logout"));
        sleep(2);
        element.click();
        sleep(2);
        
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
