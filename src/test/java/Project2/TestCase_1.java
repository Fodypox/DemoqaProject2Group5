package Project2;

public class TestCase_1 extends UtilityClass {
    public static void main(String[] args) {

        /**1. Go to the website demoqa.com(url: https://demoqa.com/ );
         * 2. Get the title of the website;
        *
        * */
        driver.get("https://demoqa.com/");
        String actualResult=driver.getTitle();
        System.out.println(actualResult);
        String expectedResult="DEMOQA";
        if(actualResult.equals(expectedResult)){
            System.out.printf("passed");
        }else{
            System.out.println("Failed");
        }

    }
}
