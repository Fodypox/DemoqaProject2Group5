//package TEST_NG;
//import Utilities.BasicDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestCase3 {

    public static WebDriver initializer(){
        System.setProperty("webdriver.chrome.driver","/Users/douaaalaaldin/IdeaProjects/Orange_HRM3Group5/chromedriver");

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");

        // Creating new instance of chromedriver
        WebDriver driver= new ChromeDriver(ops);
        driver.manage().window().maximize();
        return driver;

    }

    public static boolean doLogin(WebDriver driver,String expectedUrl) {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // setting timeout for 10 secs
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Checking username field
        WebElement userInput = driver.findElement(By.xpath("//input[@name='username']"));
        wait.until(ExpectedConditions.visibilityOf(userInput));

        // send keys
        userInput.sendKeys("Admin");

        // checking for password field
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        passwordInput.sendKeys("admin123");

        // Clicking Login Button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return driver.getCurrentUrl().equals(expectedUrl);
    }
    public static void adminAddCase(WebDriver driver){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement addBtn = driver.findElement(By.xpath(("(//button[contains(@class,'oxd-button oxd-button--medium')])[3]")));
        addBtn.click();

        WebElement saveBtn = driver.findElement(By.xpath("(//button[contains(@class,'oxd-button oxd-button--medium')])[2]"));
        saveBtn.click();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // first option
        WebElement check1 = driver.findElement(By.xpath("(//span[text()='Required'])[1]"));
        System.out.print("Element 1 Shown "+check1.isDisplayed());


        // second option
        WebElement check2 = driver.findElement(By.xpath("(//span[text()='Required'])[2]"));
        System.out.print("\nElement 2 Shown "+check2.isDisplayed());


        // third option
        WebElement check3 = driver.findElement(By.xpath("(//span[text()='Required'])[3]"));
        System.out.print("\nElement 3 Shown "+check3.isDisplayed());


        // fourth option
        WebElement check4 = driver.findElement(By.xpath("(//span[text()='Required'])[4]"));
        System.out.print("\nElement 4 Shown "+check4.isDisplayed());


        // fifth option
        WebElement check5 = driver.findElement(By.xpath("(//span[text()='Required'])[5]"));
        System.out.print("\nElement 5 Shown "+check5.isDisplayed());


        // sixth option
        WebElement check6 = driver.findElement(By.xpath("(//span[text()='Required'])[6]"));
        System.out.print("Element 6 Shown "+check6.isDisplayed());

    }
    public static void main(String[] args) {

        // Intializing driver to start chrome
        WebDriver driver= initializer();

        // calling login method to login into website
        TestCase3.doLogin(driver,"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index%22");

        TestCase3.adminAddCase(driver);
    }

}



