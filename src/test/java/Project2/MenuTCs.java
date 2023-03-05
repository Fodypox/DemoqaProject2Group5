package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MenuTCs extends UtilityClass{
    public static void main(String[] args) {

        driver.get("https://demoqa.com/menu/");

        WebElement subItem1 = driver.findElement(By.xpath("//a[text()='Sub Item']"));
        WebElement subItem2 = driver.findElement(By.xpath("(//a[text()='Sub Item'])[2]"));
        WebElement subSubList = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
        System.out.println("Before hover-over Main Item 2 is First SubItem Displayed " + subItem1.isDisplayed());
        System.out.println("Before hover-over Main Item 2 is Second SubItem Displayed " + subItem2.isDisplayed());
        System.out.println("Before hover-over Main Item 2 is SUB SUB LIST » Displayed " + subItem2.isDisplayed());
        WebElement mainItem2 = driver.findElement(By.linkText("Main Item 2"));
        System.out.println("-".repeat(50));
        System.out.println("Before hover-over Main Item 2 Background color: " + mainItem2.getCssValue("background-color"));
        System.out.println("-".repeat(50));
        Actions actions = new Actions(driver);
        Action hoverOverMainItem2 = actions.moveToElement(mainItem2).build();
        hoverOverMainItem2.perform();
        Wait(0.5);
        System.out.println("After hover-over Main Item 2 is First SubItem Displayed " + subItem1.isDisplayed());
        System.out.println("After hover-over Main Item 2 is Second SubItem Displayed " + subItem2.isDisplayed());
        System.out.println("After hover-over Main Item 2 is SUB SUB LIST » Displayed " + subItem2.isDisplayed());
        System.out.println("-".repeat(50));
        System.out.println("After hover-over Main Item 2 Background color: " +
                mainItem2.getCssValue("background-color"));
        System.out.println("-".repeat(50));
        WebElement subSubItem1 = driver.findElement(By.xpath("//a[text()='Sub Sub Item 1']"));
        WebElement subSubItem2 = driver.findElement(By.xpath("//a[text()='Sub Sub Item 2']"));
        System.out.println("Before hover-over SUB SUB LIST »  is Sub Sub Item 1 Displayed " + subSubItem1.isDisplayed());
        System.out.println("Before hover-over SUB SUB LIST »  is Sub Sub Item 2 Displayed " + subSubItem2.isDisplayed());
        System.out.println("-".repeat(50));
        System.out.println("Before hover-over SUB SUB LIST » Background color: " + subSubList.getCssValue("background-color"));
        System.out.println("-".repeat(50));
        Actions actions1 = new Actions(driver);
        Action hoverOverSubSubList = actions.moveToElement(subSubList).build();
        hoverOverSubSubList.perform();
        Wait(0.5);
        System.out.println("After hover-over SUB SUB LIST »  is Sub Sub Item 1 Displayed " + subSubItem1.isDisplayed());
        System.out.println("After hover-over SUB SUB LIST »  is Sub Sub Item 2 Displayed " + subSubItem2.isDisplayed());
        System.out.println("-".repeat(50));
        System.out.println("After hover-over SUB SUB LIST » Background color:" + subSubList.getCssValue("background-color"));
        System.out.println("-".repeat(50));
        System.out.println("Before hover-over Sub Sub Item 1 Background color: " + subSubItem1.getCssValue("background-color"));
        Actions actions2 = new Actions(driver);
        Action hoverOverSubSubItem1 = actions.moveToElement(subSubItem1).build();
        hoverOverSubSubItem1.perform();
        Wait(0.5);
        System.out.println("After hover-over Sub Sub Item 1 Background color: " + subSubItem1.getCssValue("background-color"));
        System.out.println("-".repeat(50));


        quitDriver(2);

    }
}
