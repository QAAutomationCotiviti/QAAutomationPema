package BlazeLogin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utilities.utility;

public class LoginMain {
    static final WebDriver driver = utility.WebDriver("chrome");
    static BlazeLoginElements log = new BlazeLoginElements(driver);

    public static void main(String[] args){
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
        log.login();
        log.loginForm("moonchild", "moon@123");

        log.loginClick();
//        utility.acceptAlert();
        log.loginClose();



    }

}
