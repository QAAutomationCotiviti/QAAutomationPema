package BlazeSignUp;

import BlazeLogin.BlazeLoginElements;
import org.openqa.selenium.WebDriver;
import utilities.utility;

public class SignUpMain {

    static final WebDriver driver = utility.WebDriver("chrome");
    static BlazeSignUpElements Sign = new BlazeSignUpElements(driver);

    public static void main(String[] args) {
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/");
        Sign.clickSignup();
        Sign.SignUp("moonchild","moon@123");
//        utility.acceptAlert();
    }
}
