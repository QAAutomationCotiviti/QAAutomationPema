import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

// Main class
public class loginTestCopy {

    // Main driver
    public static void main(String[] args)
    {

        WebDriver driver = new ChromeDriver();
        // URL of the login website
        driver.get("https://www.saucedemo.com/");

        // Maximize window size of browser
        driver.manage().window().maximize();

        //For valid username and password
        // Enter your valid login username
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        // Enter your valid login password
        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");


//        driver.findElement(By.className("submit-button btn_action"))
        driver.findElement(By.id("login-button"))
                .click();
    }
}
