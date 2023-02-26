package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TestSliderTCs {
    @Test(priority = 1)
    void moveTheSlider(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/slider/");
        // Find the slider element and get its location
        WebElement slider = driver.findElement(By.className("range-slider"));
        String valueBefore = slider.getAttribute("value");

        int sliderWidth = slider.getSize().getWidth();
        int sliderX = slider.getLocation().getX();
        int sliderY = slider.getLocation().getY();
        // Calculate the pixel position of the intersection at 25 on the slider
        int intersectionPos = (int) Math.round(0.25 * sliderWidth);
        int moveToPoint = (int) Math.round(0.25 * sliderWidth);


        // Slide the slider to the right
        Actions action = new Actions(driver);

        Action moveToRight = action.moveByOffset(sliderX+intersectionPos,sliderY).clickAndHold().moveByOffset(moveToPoint,0).release().build();
        moveToRight.perform();
        String valueAfter = slider.getAttribute("value");
        Assert.assertFalse(valueBefore.equals(valueAfter));
        driver.quit();
    }
    @Test(priority = 2)
    void clickOnGivenPoint(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/slider/");
        // Find the slider element and get its location
        WebElement slider = driver.findElement(By.className("range-slider"));
        String valueBefore = slider.getAttribute("value");
        int sliderWidth = slider.getSize().getWidth();
        int sliderX = slider.getLocation().getX();
        int sliderY = slider.getLocation().getY();
        // Calculate the pixel position of the intersection at 25 on the slider

        int moveToPoint = (int) Math.round(0.5 * sliderWidth);
        // Move the slider handle to the random position
        Actions action = new Actions(driver);

        Action clickOnPoint = action.moveByOffset(sliderX,sliderY).moveByOffset(moveToPoint,0).click().build();
        clickOnPoint.perform();
        String valueAfter = slider.getAttribute("value");
        Assert.assertFalse(valueBefore.equals(valueAfter));
        driver.quit();
    }
}
