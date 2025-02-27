import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {

    WebDriver driver;

    @BeforeMethod
    public void openTextTestPage() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("129");
        driver =  new ChromeDriver();

        driver.manage().window().maximize(); //window eka max krgnn
        driver.get("https://leafground.com/input.xhtml");
        Thread.sleep(3000);
    }

    @Test
    public void textBoxTests(){
        //01) Type your name.
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("sandhini gamage");


        //02) Append Country to is disabled.
        WebElement appendTex = driver.findElement(By.id("j_idt88:j_idt91"));
        appendTex.sendKeys("Sri Lanka");

        //03) Verify if text box is disabled.
        boolean enabled = driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.println("This text box is "+ enabled); 

        //04) Clear the typed text.
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        //05) Retrieve the typed text.
        WebElement textElement = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = textElement.getAttribute("value");
        System.out.println(value);

        //06) Type email and Tab.Confirm control moved to next element.
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("sandhinigamage4@gmail.com" + Keys.TAB + "Confirmed control moved to next element");

    }
    
}
