package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TestCase_2 extends UtilityClass {
    public static void main(String[] args) {
        /**url: https://demoqa.com/
        *1. Go to the website demoqa.com
         * 2. Click the “interaction” button on top menu list;
         * 3.get URL
        * */
        driver.get("https://demoqa.com/");
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        WebElement interaction=driver.findElement(By.xpath("//div/h5[text()='Interactions']"));
        interaction.click();
        driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());
        String actualResult= driver.getCurrentUrl();
        String expectedResult="https://demoqa.com/interaction/";
        if(actualResult.equals(expectedResult)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
    }
}
