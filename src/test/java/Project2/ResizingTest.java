package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class ResizingTest extends UtilityClass{
    public static void main(String[] args) {
        driver.get("https://demoqa.com/resizable/");
        String actualUrl =  driver.getCurrentUrl();
        String exceptionURL = "https://demoqa.com/resizable/";
        if (actualUrl.equals(exceptionURL)){
            System.out.println("test is pass");
        }else {
            System.out.println("test is failed");
        }
        System.out.println("-".repeat(50));
        String actualTitle = driver.getTitle();
        String exceptionTitle = "DEMOQA";
        if (actualTitle.equals(exceptionTitle)){
            System.out.println("test is pass");
        }else {
            System.out.println("test is failed");
        }
        System.out.println("-".repeat(50));

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



        if (boxSize1+100==boxSize2){
            System.out.println("test is passed");
        }else {
            System.out.println("test is filed");
        }
        System.out.println("-".repeat(50));


        quitDriver(2);

    }
}
