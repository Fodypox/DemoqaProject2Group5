package Project2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TestCase_9 extends UtilityClass{
    public static void main(String[] args) {
        driver.get("https://demoqa.com/resizable/");

        // add comint -its reject me to push
        //add some stuff its rejects again!!

//new code just add ot it (from interactionButton to resizibleButton!
//     JavascriptExecutor js = (JavascriptExecutor) driver; -delete one couse i have one alreacy!
//        Wait(6);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0, 400)"); // scrolled down by 3000 pixels
//
//        //<div class="avatar mx-auto white"><svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 1024 1024" height="1em" width="1em" xmlns="http://www.w3.org/2000/svg"><path d="M880 112H144c-17.7 0-32 14.3-32 32v736c0 17.7 14.3 32 32 32h736c17.7 0 32-14.3 32-32V144c0-17.7-14.3-32-32-32zM726 585.7c0 55.3-44.7 100.1-99.7 100.1H420.6v53.4c0 5.7-6.5 8.8-10.9 5.3l-109.1-85.7c-3.5-2.7-3.5-8 0-10.7l109.1-85.7c4.4-3.5 10.9-.3 10.9 5.3v53.4h205.7c19.6 0 35.5-16 35.5-35.6v-78.9c0-3.7 3-6.8 6.8-6.8h50.7c3.7 0 6.8 3 6.8 6.8v79.1zm-2.6-209.9l-109.1 85.7c-4.4 3.5-10.9.3-10.9-5.3v-53.4H397.7c-19.6 0-35.5 16-35.5 35.6v78.9c0 3.7-3 6.8-6.8 6.8h-50.7c-3.7 0-6.8-3-6.8-6.8v-78.9c0-55.3 44.7-100.1 99.7-100.1h205.7v-53.4c0-5.7 6.5-8.8 10.9-5.3l109.1 85.7c3.6 2.5 3.6 7.8.1 10.5z"></path></svg></div>
//        Wait(6);
//        WebElement interactionButton=driver.findElement(By.xpath("//h5[text()='Interactions']")); // not absolute
//        //we also can do WebElement testCase1=driver.findElement(By.xpath("//div/h5[text()='Interactions']"));
//        interactionButton.click();



        Wait(6);
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0, 3000)");
//        //<span class="text">Resizable</span>
//        Wait(6);
//        WebElement resizibleButton=driver.findElement(By.xpath("//span[text()='Resizable']"));
//        resizibleButton.click();











        Wait(3);
        //JavascriptExecutor js = (JavascriptExecutor) driver;     //for scroll page couse my test at the end of the page!

        js.executeScript("window.scrollBy(0, 3000)"); // scrolled down by 3000 pixels
        Wait(2);


        //WebElement resize = driver.findElement(By.xpath("//*[@id='resizable']/span"));
        WebElement resize = driver.findElement(By.xpath("//*[@id='resizable']/span"));  //"//*[@id='resizable']/span"

        Actions action = new Actions(driver);
        Wait(3);
        WebElement box = driver.findElement(By.xpath("//*[@id='resizable']")); // we moved it !!!!   //find the box !
        String sizeOne = box.getAttribute("style");  // we put it here   getAtribute mean get the size of it !
        System.out.println("size before resizing: " + sizeOne);
        //2. Drag a mouse from the bottom side of the element by 100 px down;
        Action abc1 = action.clickAndHold(resize).moveByOffset(0, 100).release().build();  //scroll down     // first element find moving throug action
        abc1.perform();
        Wait(3);
//        Action abc2 = action.clickAndHold(resize).moveByOffset(200, 0).release().build(); // scroll right !
//        abc2.perform();

        String sizeTwo = box.getAttribute("style");  // after all action //get second size after text!


        // WebElement box = driver.findElement(By.xpath("//*[@id='resizable']"));
        System.out.println("size after resizing: " + sizeTwo);   // verefication of pxls!


        // and here we verification of both sizes .equals to

        //System.out.printf(sizeTwo.equals(sizeTwo)); in one line!   - its false couse its not true!
//        if (sizeOne.equals(sizeTwo)) {
//            System.out.println("test is failed: ");
//        } else {
//            System.out.println("test is pass: ");
//        }
// expect result 200 wider
        String actualResult=sizeTwo;
        String expectedResult= "width: 400px; height: 200px;";
        if (actualResult.equals(expectedResult)){
            System.out.println("teste is: " + true + "it should be: width: 400px; height: 200px;");
        }else {
            System.out.println("taste is: " + false + " - it should be: width: 400px; height: 200px; but actual result is: " + sizeTwo);
            System.out.println(" NOTE: So by the step we drow box down and our expectation was box should get width by 200 px witch is not possible" +
                    "so the goal of the test of achived ! Its negative result! ");


            //System.out.print("CONGRATULATIONS!".repeat(100));
        }






        quitDriver(5);
    }
}


