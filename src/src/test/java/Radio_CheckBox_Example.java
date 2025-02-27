import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.List;

public class Radio_CheckBox_Example {
    WebDriver driver;

    @BeforeMethod
    public void radio_checkbox_BeforeTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void radioTests(){
        //<<<<<<<<<<Radio>>>>>>>>>>
        // 1) Find the default select radio button
        driver.get("https://leafground.com/radio.xhtml");
        boolean chromeRadioOptions = driver.findElement(By.id("j_idt87:console1:0")).isSelected();
        boolean fireFoxRadioOptions = driver.findElement(By.id("j_idt87:console1:1")).isSelected();
        boolean safariRadioOptions = driver.findElement(By.id("j_idt87:console1:2")).isSelected();
        boolean edgeRadioOptions = driver.findElement(By.id("j_idt87:console1:3")).isSelected();

        if(chromeRadioOptions){
            String chromeRadioOptionsText = driver.findElement(By.xpath("//label[@for='j_idt87:console1:0']")).getText();
            System.out.println("Default select radio button is : " + chromeRadioOptionsText);
        }else if(fireFoxRadioOptions){
            String fireFoxRadioOptionsText = driver.findElement(By.xpath("//label[@for='j_idt87:console1:1']")).getText();
            System.out.println("Default select radio button is : " + fireFoxRadioOptionsText);
        }else if(safariRadioOptions){
            String safariRadioOptionsText = driver.findElement(By.xpath("//label[@for='j_idt87:console1:2']")).getText();
            System.out.println("Default select radio button is : " + safariRadioOptionsText);
        }else if(edgeRadioOptions){
            String edgeRadioOptionsText = driver.findElement(By.xpath("//label[@for='j_idt87:console1:3']")).getText();
            System.out.println("Default select radio button is : " + edgeRadioOptionsText);
        }


//        List<WebElement> radioElements = driver.findElements(By.xpath("//TABLE[@id='j_idt87:console2']//td//input"));
//        int radioCount = radioElements.size();
//        System.out.println("Radio size : " + radioCount);
//
//        int index = -1;
//
//        for(WebElement radioElement: radioElements){
//            index++;
//            if(radioElement.isSelected()){
//                WebElement defaultSelectionRadioButton = driver.findElement(By.xpath("//lable[@for='j_idt87:console2:" + index + "']"));
//                String defaultSelectionRadioButtonText = defaultSelectionRadioButton.getText();
//                System.out.println("Default Selected Radio Button Text : " + defaultSelectionRadioButtonText);
//                break;
//            }
//        }

        // 2) Select the age group (Only if not selected)
        WebElement myAgeGroup = driver.findElement(By.id("j_idt87:age:0"));
        boolean isChecked = myAgeGroup.isSelected();
        if(!isChecked){
            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
        }
        //(isChecked! = true)

//        String myAge = "1-20 Years";
//        List<WebElement> ageGroup = driver.findElements(By.xpath("//div[@id = 'j_id87:age']//label"));
//
//        for(WebElement element:ageGroup){
//            String ageGroupText = element.getText();
//            if(ageGroupText.equals(myAge)){
//                WebElement myAgeRadioOption = driver.findElement(By.xpath("//label[text()='"+ ageGroupText + "']/parent::div//input"));
//                if(!myAgeRadioOption.isSelected()){
//                    element.click();
//                }
//                break;
//            }
//        }
    }

    @Test
    public void CheckBoxTests(){
        //<<<<<<<<<<CheckBox>>>>>>>>>>
        // 1) Select wanted checkboxes and verifying those checkboxes selected status.
        driver.get("https://leafground.com/checkbox.xhtml");

        List<WebElement> checkBoxList = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for(WebElement element : checkBoxList){
            if(!(element.getText().equals("Others"))){
                element.click();
            }
        }

        //verifying those checkboxes selected status.
        for(int i=1; i<=checkBoxList.size(); i++){
            boolean checkBoxStatus =  driver.findElement(By.xpath("(//table[@id = 'j_idt87:basic']//input)["+i +"]")).isSelected();
            System.out.println("CheckBox " +i + "Selected status is : " + checkBoxStatus);
        }
    }

}
