import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestAutomation {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");

        // Initialize the Chrome WebDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the login page
        driver.get("https://www.saucedemo.com/");

        // Scenario 1: Valid Login
        login(driver, "standard_user", "secret_sauce");

        // Scenario 2: Invalid Username
        login(driver, "invalidUsername", "validPassword");

        // Scenario 3: Invalid Password
        login(driver, "validUsername", "invalidPassword");

        // Scenario 4: Empty Fields
        login(driver, "", "");

        // Scenario 5: Empty Password
        login(driver, "validUsername", "");

        // Scenario 6: Empty Username
        login(driver, "", "validPassword");

        // Scenario 7: Password Case Sensitivity
        login(driver, "validUsername", "Password");

        // Scenario 8: Account Lockout (simulate multiple login attempts)
        for (int i = 0; i < 5; i++) {
            login(driver, "validUsername", "wrongPassword");
        }

        // Scenario 9: Forgot Password
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password"));
        forgotPasswordLink.click();

        // Add more scenarios as needed...

        // Close the browser
//        driver.quit();
    }

    private static void login(WebDriver driver, String username, String password) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("loginButton"));

        // Enter username and password
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        // Click the login button
        loginButton.click();

        // Add verification steps for the login result here
        // For example, check for error messages or successful login indicators
    }
}

