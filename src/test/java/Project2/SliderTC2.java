package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SliderTC2 extends UtilityClass{
    public static void main(String[] args) {

        driver.get("https://demoqa.com/slider/");

        // Find the slider element
        WebElement slider = driver.findElement(By.className("range-slider"));
        int sliderWidth = slider.getSize().getWidth();
        int sliderX = slider.getLocation().getX();
        int sliderY = slider.getLocation().getY();
        // Calculate the pixel position of the intersection at 25 on the slider

        int moveToPoint = (int) Math.round(0.5 * sliderWidth);
        // Move the slider handle to the random position
        Actions action = new Actions(driver);
        Wait(2);
        Action clickOnPoint = action.moveByOffset(sliderX,sliderY).moveByOffset(moveToPoint,0).click().build();
        clickOnPoint.perform();
        quitDriver(2);
    }
}
