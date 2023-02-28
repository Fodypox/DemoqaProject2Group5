package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SelectableButtonTC1 extends UtilityClass{
    /**
     * Go to 1. Go to the url: https://demoqa.com/selectable/
     * 2. Click on Item 1 on the selectable list;
     * */
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://demoqa.com/selectable/");


        WebElement item1 = driver.findElement(By.xpath("//li[@class='mt-2 list-group-item list-group-item-action']"));
        String colorBeforeClick = item1.getCssValue("background-color");
        System.out.println(colorBeforeClick);
        item1.click();
        String colorAfterClick = item1.getCssValue("background-color");
        System.out.println(colorAfterClick);

        if(colorAfterClick.equals(colorAfterClick)){
            System.out.println("Item is highlighted");
        } else {
            System.out.println("Item is not highlighted");
        }

    }
}
