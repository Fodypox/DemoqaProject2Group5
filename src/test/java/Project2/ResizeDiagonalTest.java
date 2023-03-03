package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
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

    @Test (priority = 1)
    public void testResizableBox1() {

        WebElement resizableBox1 = driver.findElement(By.id("resizableBoxWithRestriction"));
        Dimension initialSize = resizableBox1.getSize();
        System.out.println("Initial size of the first resizable box: " + initialSize);

        int initialWidth = initialSize.getWidth();
        int initialHeight = initialSize.getHeight();

        WebElement resizeHandle = driver.findElement(By.xpath("//div[@id='resizableBoxWithRestriction']//span[@class='react-resizable-handle react-resizable-handle-se']"));

        Actions actions = new Actions(driver);
        Action resizeAction = actions.clickAndHold(resizeHandle)
                .moveByOffset(-initialWidth, -initialHeight)
                .release()
                .build();
        resizeAction.perform();

        Dimension finalSize = resizableBox1.getSize();
        System.out.println("The size after resizing the box to minimum: " + finalSize);

        int finalWidth = resizableBox1.getSize().getWidth();
        int finalHeight = resizableBox1.getSize().getHeight();

        Assert.assertTrue(finalHeight < initialHeight && finalWidth < initialHeight, "FAILED: Box is not minimized");
    }

    @Test (priority = 2)

    public void testResizableBox2(){

        WebElement resizableBox2 = driver.findElement(By.id("resizable"));

        Dimension initialSize2 = resizableBox2.getSize();
        System.out.println("Initial size of the second resizable box: " + initialSize2);

        int initialWidth2 = initialSize2.getWidth();
        int initialHeight2 = initialSize2.getHeight();

        WebElement resizeHandle2 = driver.findElement(By.xpath("//div[@id='resizable']//span[@class='react-resizable-handle react-resizable-handle-se']"));

        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", resizableBox2);


        Action resizeAction2 = actions.clickAndHold(resizeHandle2)
                .moveByOffset(-initialWidth2,-initialHeight2)
                .release()
                .build();
        resizeAction2.perform();

        Dimension finalSize2 = resizableBox2.getSize();
        System.out.println("The size after resizing the box to minimum: " + finalSize2);

        int finalWidth2 = resizableBox2.getSize().getWidth();
        int finalHeight2 = resizableBox2.getSize().getHeight();

        Assert.assertTrue(finalHeight2 < initialHeight2 && finalWidth2 < initialHeight2, "FAILED: Box is not minimized");

    }

    @AfterClass
    public void quit() {
        Wait(2);
        driver.quit();
    }

}




