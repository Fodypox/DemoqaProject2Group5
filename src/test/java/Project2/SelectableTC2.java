package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class SelectableTC2 extends UtilityClass {
    /***
     * 1. Go to the url: https://demoqa.com/selectable/
     * 2. Press ctrl/cmd button;
     * 3. Click on Item 1 on the selectable list;
     * 4. Click on Item 2 on the selectable list;
     * 5. Click on Item 3 on the selectable list;
     * 6. Release ctrl/cmd button
     */
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://demoqa.com/selectable/");

        //<ul id="verticalListContainer" class="vertical-list-container mt-4 list-group"><li
        // class="mt-2 list-group-item list-group-item-action">Cras justo odio</li><li
        // class="mt-2 list-group-item list-group-item-action">Dapibus ac facilisis in</li><li
        // class="mt-2 list-group-item list-group-item-action">Morbi leo risus</li><li
        // class="mt-2 list-group-item list-group-item-action">Porta ac consectetur ac</li></ul>

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
            if (!beforeClick.get(i).equals(afterClick.get(i))) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
            }
        }
    }
}
