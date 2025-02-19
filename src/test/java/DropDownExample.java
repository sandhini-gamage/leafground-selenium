import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample {

    WebDriver driver;

    @BeforeMethod
    public void dropDownTestPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize(); //window eka max krgnn

    }

    @Test
    public void leafGroundPageDropdownTest() throws InterruptedException {

        //1.1) Ways of select values in Basic dropdown
        driver.get("https://leafground.com/select.xhtml");
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropdown);  // select is a class
        select.selectByIndex(2);
        Thread.sleep(3000);
        select.selectByVisibleText("Playwright");
        Thread.sleep(3000);

        //1.2) Get the number of dropdown options
        //generics
        List<WebElement> listOfOptions = select.getOptions();
        int size = listOfOptions.size();
        System.out.println("Number of Elements in Dropdown :" + size);

        for(WebElement element: listOfOptions){
            System.out.println(element.getText());
        }

        //1.3) Using sendKeys select dropdown value
        dropdown.sendKeys("Puppeteer");
        Thread.sleep(3000);

        //1.4) Selecting value in a Bootstrap dropdown
        WebElement dropDown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropDown2.click();
        System.out.println("work1");
        List<WebElement> listOfDropDown2Values = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']"));
        System.out.println("work2");
        for(WebElement element : listOfDropDown2Values){
           String dropDownValue = element.getText();
            System.out.println("work3");
           if(dropDownValue.equals("USA")){
               System.out.println("work4");
               element.click();
               break;
           }
        }
    }

    //2) Google search - pick a value from suggestions
    public void googleSearchDropDown() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("palitha");
        Thread.sleep(3000);
        List<WebElement> googleSearchList = driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d'] "));
        System.out.println(googleSearchList.size());
        for(WebElement element : googleSearchList){
            System.out.println(element.getText());
        }
    }
    //3) Handle Hidden Auto Suggestions DropDown and search using DOM Debugger Trick

}
