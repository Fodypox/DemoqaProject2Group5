package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Select extends  UtilityClass{
    public void main(String[] args) {
        /**1- Go to the url:  https://demoqa.com/select-menu/
         2- Select one option from Select Value drop down menu
         3- Select one option from Select One drop down menu
         4- Select one option from Old Style Select Menu drop down menu
         5- Select options from Multiselect drop down menu
         6- Select one option from Standard multi select drop down menu
        * */
        driver.get("https://demoqa.com/select-menu/");
        Wait(2);
        WebElement SelectValue= driver.findElement(By.xpath("//div[class='css-1wa3eu0-placeholder']"));
        SelectValue.click();
    }
}
