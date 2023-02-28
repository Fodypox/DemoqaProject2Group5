package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;




public class TestCase_12 extends UtilityClass{
    public static void main(String[] args) {
/**1- Go to the url:  https://demoqa.com/select-menu/
 2- Select one option from Select Value drop down menu
 3- Select one option from Select One drop down menu
 4- Select one option from Old Style Select Menu drop down menu
 5- Select options from Multiselect drop down menu
 6- Select one option from Standard multi select drop down menu
 * */
        driver.get("https://demoqa.com/select-menu/");
         Wait(2);
        // WebElement SelectValue=driver.findElement(By.xpath("//div[@class=' css-tlfecz-indicatorContainer']")); Arrow sign
        WebElement valueeeeee = driver.findElement(By.id("withOptGroup"));
        valueeeeee.click();
        Wait(2);
        WebElement options=driver.findElement(By.xpath("//div[text()='Group 2, option 1']"));
        options.click();
        WebElement selectOne = driver.findElement(By.id("selectOne"));
        selectOne.click();
        Wait(2);
        WebElement title = driver.findElement(By.xpath("//div[text()='Mrs.']"));
        title.click();
        WebElement oldStyleMenu = driver.findElement(By.id("oldSelectMenu"));
        Select oldStyle = new Select(oldStyleMenu);
        oldStyle.selectByValue("3");
        WebElement multiColor= driver.findElement(By.xpath("//div[text()='Select...']"));
        multiColor.click();
        WebElement green= driver.findElement(By.xpath("//div[text()='Green']"));
        green.click();
        WebElement blue= driver.findElement(By.xpath("//div[text()='Blue']"));
        blue.click();
        multiColor= driver.findElement(By.xpath("//div[text()='Select...']"));
        multiColor.click();
        WebElement standardMultiSelect= driver.findElement(By.id("cars"));
        Select car=new Select(standardMultiSelect);
        car.selectByValue("audi");
        //quitDriver(3);


    }
}
