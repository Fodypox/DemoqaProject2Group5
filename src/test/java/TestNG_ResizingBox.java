import Project2.UtilityClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_ResizingBox extends UtilityClass {
    @Test
    public void titleTest(){
        driver.get("https://demoqa.com/resizable/");
        String actualUrl =  driver.getCurrentUrl();
        String exceptionURL = "https://demoqa.com/resizable/";
        Assert.assertEquals(actualUrl,exceptionURL,"filed");
    }
    @Test
    public void resizingTest(){
        titleTest();
        Wait(3);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0, 1000)"); // scrolled down by 1000 pixels
        Wait(2);

        WebElement box1 = driver.findElement(By.xpath("//*[@id='resizableBoxWithRestriction']"));
        int boxSize1 = box1.getSize().width;
        String size = box1.getAttribute("style");
        System.out.println(boxSize1);
        WebElement elem1 = driver.findElement(By.xpath("//*[@id='resizableBoxWithRestriction']/span"));


        Actions action = new Actions(driver);
        Wait(3);
        Action rts = action.clickAndHold(elem1).moveByOffset(100,0).release().build();
        rts.perform();

        int boxSize2 = box1.getSize().width;
        Wait(3);
        Action rts1 = action.clickAndHold(elem1).moveByOffset(0,100).release().build();
        rts1.perform();
        String size2 = box1.getAttribute("style");
        System.out.println(boxSize2);

        Assert.assertEquals(boxSize1+100,boxSize2,"filed");

        quitDriver(6);
    }
}
