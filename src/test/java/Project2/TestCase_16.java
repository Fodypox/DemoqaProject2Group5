package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Calendar;

public class TestCase_16 extends UtilityClass  {

    public static void main(String[] args){

        /*
        1. Go to the url: https://demoqa.com/date-picker/ 
        2. Click on the input field;
        3. Check if the highlighted date is today’s date;
         */

driver.get("https://demoqa.com/date-picker/");

// <input type="text" id="datePickerMonthYearInput" class="" value="03/01/2023">
        WebElement calender=driver.findElement(By.id("datePickerMonthYearInput"));
        calender.click();

        String expectedResult="https://demoqa.com/date-picker/";
        String actualResult=driver.getCurrentUrl();
        if(actualResult.equals(expectedResult)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

        System.out.println(actualResult);

       // driver.quit();
    }


    }



