package Project2;

import jdk.jshell.execution.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SelectableButtonTC2 extends UtilityClass {
    /***
     * 1. Go to the url: https://demoqa.com/selectable/
     * 2. Press ctrl/cmd button;
     * 3. Click on Item 1 on the selectable list;
     * 4. Click on Item 2 on the selectable list;
     * 5. Click on Item 3 on the selectable list;
     * 6. Release ctrl/cmd button
     */
    public static void main(String[] args) {
        driver.get("https://demoqa.com/selectable/");

        Actions action = new Actions(driver);
        Action pressCtrl = action.sendKeys(Keys.CONTROL).build();
        pressCtrl.perform();
        WebElement item1 = driver.findElement(By.xpath("//li[@class='mt-2 list-group-item list-group-item-action']"));
        item1.click();
        WebElement item2 = driver.findElement(By.linkText("Morbi leo risus"));
        item2.click();

    }
}
