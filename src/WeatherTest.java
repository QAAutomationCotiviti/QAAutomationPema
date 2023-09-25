import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ObjectInputStream;

public class WeatherTest {
    WeatherTest(WebDriver d, String s){
        WebDriver driver=d;
        String searching=s;
        WebElement search = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        search.clear();
        search.sendKeys(searching);
        search.sendKeys(Keys.ENTER);

        String temperature = driver.findElement(By.id("wob_tm")).getText();
        String day = driver.findElement(By.id("wob_dts")).getText();
        String weather = driver.findElement(By.id("wob_dc")).getText();
        String location = driver.findElement(By.xpath("//span[@class='BBwThe']")).getText();

        System.out.println("For "+ day);
        System.out.println("Temperature is :"+ temperature + "°C");
        System.out.println("Weather is :"+ weather);
        System.out.println("Location is :"+ location + "\n");
    }

    public static void main(String[] args) {

        //translate to english another way
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--lang=en-GB");
//        WebDriver driver = new ChromeDriver(options);

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        WebElement translateAnchorTag = driver.findElement(By.xpath("//div[@id='SIvCob']//a"));
        translateAnchorTag.click();

        WebElement searchBar= driver.findElement(By.id("APjFqb"));
        searchBar.sendKeys("weather today");
        searchBar.submit();
//
        WeatherTest tomorrow= new WeatherTest(driver,"Weather Tomorrow");

// Thread.sleep(3000);

//to display temperature
// WebElement temperatureElement = driver.findElement(By.id("wob_dcp"));
        WebElement temperatureElement = driver.findElement(By.xpath("//span[@class='wob_t q8U8x']"));

        String temperature = temperatureElement.getText();
        System.out.println("Temperature today: " + temperature);

        String temperature2 = temperatureElement.getText();
        System.out.println("Temperature tommorow: " + temperature2);

//to display temperature status

        WebElement weatherElement = driver.findElement(By.id("wob_dcp"));
        String weatherStatus= weatherElement.getText();

        System.out.println("Weather Status Today: "+ weatherStatus);

//        driver.close();

    }
}