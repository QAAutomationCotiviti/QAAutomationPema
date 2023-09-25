import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//#garishacode
public class runTest {
    static WebDriver driver= new ChromeDriver();

    public void myuserfunction(String s, String p) {

        WebElement user= driver.findElement(By.id("user-name"));
        user.sendKeys(s);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(p);

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();


    }

    public void afterLogin(){

        String textname1 = driver.findElement(By.id("item_4_title_link")).getText();
        System.out.println(textname1);


        String textname2 = (driver.findElement(By.id("item_0_title_link")).getText());
        System.out.println(textname2);


        String textname3 = ( driver.findElement(By.id("item_1_title_link")).getText());
        System.out.println(textname3);

        String textname4 = (driver.findElement(By.id("item_5_title_link")).getText());
        System.out.println(textname4);

        String textname5 = (driver.findElement(By.id("item_2_title_link")).getText());
        System.out.println(textname5);

        String textname6 = ( driver.findElement(By.id("item_3_title_link")).getText());
        System.out.println(textname6);

    }


    public static void main(String[] args) {

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        runTest obj = new runTest();
        obj.myuserfunction("standard_user","secret_sauce");
        obj.afterLogin();

    }
}