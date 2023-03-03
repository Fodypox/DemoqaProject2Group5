package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ResizeDiagonalTest extends UtilityClass {

    @BeforeClass
    public void setupDriver() {

        driver.get("https://demoqa.com/resizable/");
        Wait(2);
    }

    @Test
    public void testResizableBox() {

        WebElement resizableBox = driver.findElement(By.id("resizableBoxWithRestriction"));
        Dimension initialSize = resizableBox.getSize();
        System.out.println("Initial size of the resizable box: " + initialSize);

        int initialWidth = initialSize.getWidth();
        int initialHeight = initialSize.getHeight();

        WebElement resizeHandle = driver.findElement(By.xpath("//div[@id='resizableBoxWithRestriction']//span[@class='react-resizable-handle react-resizable-handle-se']"));

        Actions actions = new Actions(driver);
        Action resizeAction = actions.clickAndHold(resizeHandle)
                .moveByOffset(-initialWidth, -initialHeight)
                .release()
                .build();
        resizeAction.perform();

        Dimension finalSize = resizableBox.getSize();
        System.out.println("The size after resizing the box to minimum: " + finalSize);

        int finalWidth = resizableBox.getSize().getWidth();
        int finalHeight = resizableBox.getSize().getHeight();

        Assert.assertTrue(finalHeight < initialHeight && finalWidth < initialHeight, "FAILED: Box is not minimized");
    }

    @AfterClass
    public void quit() {
        Wait(2);
        driver.quit();
    }

}




