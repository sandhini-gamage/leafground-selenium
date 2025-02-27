import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver =  new ChromeDriver();
        driver.manage().window().maximize(); //window eka max krgnn
        driver.get("https://leafground.com/link.xhtml");
    }
    @Test
    public void LinkTest(){

        //01) Take me to dashboard
            WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
            homeLink.click();
            driver.navigate().back();

        //02) Find my destination
            WebElement whereToGo =  driver.findElement(By.partialLinkText("Find the URL"));
            String path =  whereToGo.getAttribute("href");
            System.out.println("This link is going to:" + path);

        //03) An I broken link?
            WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
            brokenLink.click();

            String title = driver.getTitle();
            assert title != null;
            if(title.contains("404")) {
                System.out.println("The link is broken");
            }else {
                System.out.println("Not Broken");
            }
            driver.navigate().back();

        //04)Duplicate Link
        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();



        //05)Count page Links
            List<WebElement> countFullpageLinks = driver.findElements(By.tagName("a"));
            int pageLinksCount = countFullpageLinks.size();
            System.out.println("Count of full page links :" + pageLinksCount);

        //06)Count layout Links
            WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
            List<WebElement> countOfLayoutLinks = layoutElement.findElements(By.tagName("a"));
            System.out.println("Count of layoutlinks :" + countOfLayoutLinks.size());


    }


}







