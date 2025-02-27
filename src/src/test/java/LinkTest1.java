import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class LinkTest1 {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage1(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/link.xhtml");
    }
    @Test
    public void TestLink(){

        //01). Take me a Dashboard
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();

        //02). Find my destination
        WebElement whereWeGo = driver.findElement(By.partialLinkText("Find the URL"));
        String path = whereWeGo.getAttribute("href");
        System.out.println("This link is going to:"+path);

    }



}
