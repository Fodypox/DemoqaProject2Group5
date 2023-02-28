package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TestCase_3 extends UtilityClass {
    public static void main(String[] args) {
        /**1. Go to the website demoqa.com;
         * 2. Click on the “interaction” button on top menu list;
         3. Click on the “Resizable“ link on left sidebar;
         * */
        driver.get("https://demoqa.com/");
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        WebElement interaction=driver.findElement(By.xpath("//div/h5[text()='Interactions']"));
        interaction.click();
        js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        WebElement Resizable=driver.findElement(By.xpath("//span[text()='Resizable']"));
        Resizable.click();
        String expectedResult="https://demoqa.com/resizable";
        String actualResult=driver.getCurrentUrl();
        if(actualResult.equals(expectedResult)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

        System.out.println(actualResult);
    }
}
