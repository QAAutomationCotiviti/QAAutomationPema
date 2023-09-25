import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WeatherApp {

    public static void main(String[] args) {
        try {
            // Set the path to the ChromeDriver executable
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

            // Initialize the Chrome WebDriver
            WebDriver driver = new ChromeDriver();

            // Open the weather website
            driver.get("https://www.weather.com");

            // Locate and interact with the search input field
            WebElement searchInput = driver.findElement(By.name("search"));
            searchInput.sendKeys("YourCityName"); // Replace with your city's name
            searchInput.submit();

            // Wait for the search results to load (you might need to add an explicit wait here)

            // Locate the today's weather element
            WebElement todayWeather = driver.findElement(By.cssSelector(".today_nowcard-temp"));
            String todayWeatherText = todayWeather.getText();

            // Locate the tomorrow's weather element
            WebElement tomorrowWeather = driver.findElement(By.cssSelector(".tombstone-container .temp"));
            String tomorrowWeatherText = tomorrowWeather.getText();

            // Print the weather information
            System.out.println("Today's Weather: " + todayWeatherText);
            System.out.println("Tomorrow's Weather: " + tomorrowWeatherText);

            // Close the browser
//            driver.quit();
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}

