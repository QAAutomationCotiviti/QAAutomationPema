import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
//for sorting array list
import java.util.ArrayList;

public class ListSorting {

    public static void main(String[] args) {

        // Converting integer to duration
        int seconds = 5;
        java.time.Duration duration = java.time.Duration.ofSeconds(seconds);

        System.out.println("Duration: " + duration);

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(9));

        try {
            driver.get("https://www.saucedemo.com/");

            driver.manage().window().maximize();

            // For valid username and password
            WebElement usernameField = driver.findElement(By.id("user-name"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("login-button"));

            usernameField.sendKeys("standard_user");
            passwordField.sendKeys("secret_sauce");
            loginButton.click();

            // Waiting for product list and page to load
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_item")));

            // sorting tigger garna elemnt click garne A to z
            WebElement sortButton = driver.findElement(By.className("product_sort_container"));
            sortButton.click();

            // Waiting for the page to reload with the sorted products
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("inventory_item")));

            // Find all product elements and list their names
            List<WebElement> productElements = driver.findElements(By.className("inventory_item"));
            List<String> productNames = new ArrayList<>();
//            System.out.println("List of Products:");

            for (WebElement productElement : productElements) {
                WebElement productNameElement = productElement.findElement(By.className("inventory_item_name"));
                String productName = productNameElement.getText();
//                System.out.println(productName);
                productNames.add(productName);
            }
            // Sort the product names in ascending order
            Collections.sort(productNames);

            // Print the sorted product names
            System.out.println("List of Products (Sorted in Ascending Order):");
            for (String productName : productNames) {
                System.out.println(productName);
            }



        } catch (Exception e) {
            // Handle any exceptions here (e.g., element not found, login failed)
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
//            driver.quit();
        }
    }
}

