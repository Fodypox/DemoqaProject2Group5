package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class TestCase_18 extends UtilityClass{

    public static void main(String[] args) throws InterruptedException {

        driver.get("https://demoqa.com/date-picker%22");


                WebElement datePickerInput = driver.findElement(By.id("datePickerMonthYearInput"));
        datePickerInput.click();
        Thread.sleep(2000);

        // Clear the default value using JavaScript
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].value = '';", datePickerInput);

        datePickerInput.sendKeys("01/14/0030");
        Thread.sleep(2000);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();", datePickerInput);

        System.out.println("datepicker value" + datePickerInput.getAttribute("value")); // datepicker value01/14/0030

        datePickerInput.sendKeys(Keys.ENTER);

        System.out.println("datepicker 2. value" + datePickerInput.getAttribute("value")); //datepicker 2. value01/14/2030

        Thread.sleep(2000);

        String expected = "21/12/2030";
        System.out.println("expected calendar with highlighted date= " + expected);

        String actual = datePickerInput.getAttribute("value");
        System.out.println("actual calendar with highlighted date = " + actual);

        SoftAssert softAssert = new SoftAssert();
        Assert.assertEquals(actual, expected);
        softAssert.assertAll();

        /**
         expected calendar with highlighted date= 21/12/2030
         actual calendar with highlighted date = 01/14/2030
         */

        driver.quit();

    }
}
