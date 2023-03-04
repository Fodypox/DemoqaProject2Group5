package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static Project2.UtilityClass.driver;

public class TestCase_17 extends UtilityClass{

    public static void main(String[] args) {



        /*
        1. Go to the url: https://demoqa.com/datepicker/ 
        2. Write the date 12/21/2019 in the input field;
         */

        /* Expected Result:
        After writing a date in format 12/21/2019
        you should see a calendar with highlighted date 21/12/2019
         */

        driver.get("https://demoqa.com/date-picker/");
        WebElement calender = driver.findElement(By.id("datePickerMonthYearInput"));
        calender.click();
    }
        @Test
        void validateTodayDate(){
            driver.get("https://demoqa.com/date-picker/%22");

                    LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            WebElement dateInput = driver.findElement(By.xpath("//[@id='datePickerMonthYearInput']"));
            String actualDate = dateInput.getAttribute("value");
            String expectedDate = localDateTime.format(formatter);
            Assert.assertEquals(actualDate,expectedDate,"Test is not successful");
        }

        @Test
        void validateDateInput1(){
            driver.get("https://demoqa.com/date-picker/%22");

                    WebElement dateInput = driver.findElement(By.xpath("//[@id='datePickerMonthYearInput']"));
            String selectAll = Keys.chord(Keys.CONTROL, "a");
            dateInput.sendKeys(selectAll);
            dateInput.sendKeys("https://demoqa.com/date-pickerys.DELETE");
            dateInput.sendKeys("12/21/2019");


            WebElement date = driver.findElement(By.id("datePickerMonthYearInput"));
            String actual = date.getAttribute("value");
            String expected = "21/12/2019";
            Assert.assertEquals(actual,expected, "Test validate 12/21/2019 fails");
        }

        @Test
        void validateDateInput2(){
            driver.get("https://demoqa.com/date-picker/%22");

                    WebElement dateInput = driver.findElement(By.xpath("//*[@id='datePickerMonthYearInput']"));
            String selectAll = Keys.chord(Keys.CONTROL, "a");
            dateInput.sendKeys(selectAll);
            dateInput.sendKeys(Keys.DELETE);
            dateInput.sendKeys("01/14/0030");

            WebElement date = driver.findElement(By.id("datePickerMonthYearInput"));
            String actual = date.getAttribute("value");
            String expected = "21/12/2030";
            Assert.assertEquals(actual,expected, "Test validate 01/14/0030 fails");

    }
}

