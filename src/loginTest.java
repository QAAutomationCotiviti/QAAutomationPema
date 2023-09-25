import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // Case 1: Valid username and password
        login(driver, "standard_user", "secret_sauce");

        // Case 2: Invalid username and password
        login(driver, "invalid_user", "invalid_password");

        // Case 3: Empty username and password fields
        login(driver, "", "");

        // Close the browser
        driver.quit();
    }

    public static void login(WebDriver driver, String username, String password) {
        // Find username and password fields and login button
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        // Clear the fields
        usernameField.clear();
        passwordField.clear();

        // Enter username and password
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        // Click the login button
        loginButton.click();

        // Check if the login was successful or not
        WebElement errorMessage = driver.findElement(By.cssSelector("[data-test='error']"));
        WebElement successMessage = driver.findElement(By.cssSelector("[data-test='success']"));

        if (errorMessage.isDisplayed()) {
            System.out.println("Login with credentials: " + username + " / " + password + " failed. Error message: " + errorMessage.getText());
        } else if (successMessage.isDisplayed()) {
            System.out.println("Login with credentials: " + username + " / " + password + " succeeded. User is logged in.");
        } else if (username.isEmpty() && password.isEmpty()) {
            System.out.println("Login with empty credentials failed. Error message: " + errorMessage.getText());
        } else {
            System.out.println("Login with credentials: " + username + " / " + password + " failed.");
        }
    }
}
