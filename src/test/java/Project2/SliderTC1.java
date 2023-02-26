package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SliderTC1 extends UtilityClass {
    public static void main(String[] args) {
        driver.get("https://demoqa.com/slider/");
        // Find the slider element and get its location
        WebElement slider = driver.findElement(By.className("range-slider"));
        int sliderWidth = slider.getSize().getWidth();
        int sliderX = slider.getLocation().getX();
        int sliderY = slider.getLocation().getY();
        // Calculate the pixel position of the intersection at 25 on the slider
        int intersectionPos = (int) Math.round(0.25 * sliderWidth);
        int moveToPoint = (int) Math.round(0.25 * sliderWidth);


        // Slide the slider to the right
        Actions action = new Actions(driver);
        Wait(2);
        Action moveToRight = action.moveByOffset(sliderX+intersectionPos,sliderY).clickAndHold().moveByOffset(moveToPoint,0).release().build();
        moveToRight.perform();

        quitDriver(2);

    }
}
