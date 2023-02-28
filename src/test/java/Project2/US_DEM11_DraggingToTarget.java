package Project2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class US_DEM11_DraggingToTarget {

    /** US_DEM-11: As a User, I should be able to go to demoqa.com, then go to “Widgets” → “Interactions”,
     * then in dropdown menu select “Droppable”, then validate User can move “Drag me” to “Drop here”.*/

    /**
     * Expected Result:
     * After dragging the element to the target, you should see the element is within the target square
     * and the target square is colored blue with inscription „Dropped!”
     */





    @Test
    void DragAndDrop() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/droppable/");
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

       /* WIDGETS:
        <svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 24 24" height="1em" width="1em" xmlns="http://www.w3.org/2000/svg"><path d="M13 13v8h8v-8h-8zM3 21h8v-8H3v8zM3 3v8h8V3H3zm13.66-1.31L11 7.34 16.66 13l5.66-5.66-5.66-5.65z"></path></svg>

        WebElement widgets = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[4]/div/div[2]/svg"));
        widgets.click();
        WebElement interactions = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[5]/span/div/div[1]"));
        interactions.click();
        WebElement droppable = driver.findElement(By.xpath("//*[@id=\"item-3\"]/span"));
        droppable.click(); */

        WebElement dragMeObject = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        WebElement dropMeArea = driver.findElement(By.id("droppable"));

        //Actions class method to drag and drop
        Actions builder = new Actions(driver);

        //Performing drag and drop
        builder.dragAndDrop(dragMeObject, dropMeArea).perform();

        //Verifying that the title has changed
        String name = dragMeObject.getText();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       // System.out.println(dropMeArea.getAttribute(".droppable-container .ui-state-highlight"));

        System.out.println(dropMeArea.getText());

        if (dropMeArea.getText().equals("Dropped!")) {
            System.out.println("Test was successfully verified!");
        } else {
            System.err.println("Test was failed!");
        }


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();

    }
}
