import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ButtonExample {    

    WebDriver driver;
    @BeforeMethod
    public void openTextTestPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize(); //window eka max krgnn
        driver.get("https://leafground.com/button.xhtml");

    }

    @Test
    public void buttonTests(){

        //1) Click and Confirm title.
        //Assert.assertEquals(actualTitle,expectedTitle,"Title miss matched");
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String expectedTitleResult  = "Dashboard";
        String actualTitleResult = driver.getTitle();
        if(actualTitleResult.equals(expectedTitleResult)){
            System.out.println("Real Title matches Expected Title");
        }else{
            System.out.println("Real Title differs from expected Title");
        }

        //2) Find the position of the submit button
        driver.navigate().back();
        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPoint = getPosition.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();
        System.out.println("X position is : " + x + "Y position is : " + y);

        //3) Find the save button colour

        WebElement findButtonColour = driver.findElement(By.id("j_idt88:j_idt96"));
        String backgroundColor = findButtonColour.getCssValue("background-color");
        System.out.println("Button colour is: "+ backgroundColor);
        
        //4) Find the Height and Width of this button
        WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
        int height = size.getSize().getHeight();
        int width = size.getSize().getWidth();
        System.out.println("Height : " + height + "Width : " + width);
    }
}
