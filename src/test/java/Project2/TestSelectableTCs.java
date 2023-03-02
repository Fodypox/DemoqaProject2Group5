package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSelectableTCs extends UtilityClass {
    @Test
    void selectableTC1() {
        driver.get("https://demoqa.com/selectable/");
        WebElement item1 = driver.findElement(By.xpath("//li[@class='mt-2 list-group-item list-group-item-action']"));
        String colorBeforeClick = item1.getCssValue("background-color");
        System.out.println(colorBeforeClick);
        item1.click();
        String colorAfterClick = item1.getCssValue("background-color");
        System.out.println(colorAfterClick);

        Assert.assertEquals(colorAfterClick, colorAfterClick, "Test has failed");
        System.out.println("PASS");

    }

    @Test
    void selectableTC2() {
        driver.get("https://demoqa.com/selectable/");
        List<WebElement> selectables = driver.findElements(By.xpath("//ul[@id='verticalListContainer']/li"));
        Actions actions = new Actions(driver);
        List<String> beforeClick = new ArrayList<>();
        List<String> afterClick = new ArrayList<>();
        actions.keyDown(Keys.LEFT_CONTROL).build().perform();
        for (int i = 0; i < selectables.size() - 1; i++) {
            beforeClick.add(selectables.get(i).getCssValue("background-color"));
            System.out.println(beforeClick.get(i));
            selectables.get(i).click();
            afterClick.add(selectables.get(i).getCssValue("background-color"));
            System.out.println(afterClick.get(i));
        }
        actions.keyUp(Keys.LEFT_CONTROL).build().perform();
        for (int i = 0; i < selectables.size() - 1; i++) {
            Assert.assertNotEquals(beforeClick.get(i), afterClick.get(i), "Test is failed");
            System.out.println("PASS");
        }
    }

    @Test(dependsOnMethods = "selectableTC2")
    void selectableTC3() {
        WebElement first = driver.findElement(By.xpath("(//ul[@id='verticalListContainer']/li)[2]"));
        first.click();
        String colorAfterSecondCLick = first.getCssValue("background-color");
        String expectedColor = "rgba(0, 123, 255, 1)";
    }
}

