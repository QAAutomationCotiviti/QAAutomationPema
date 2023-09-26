import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Sorting {
    static WebDriver driver= new ChromeDriver();

    public void newfunction(String s, String p) {

        WebElement user = driver.findElement(By.id("user-name"));
        user.sendKeys(s);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(p);

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        sortingelement("ascending");
        sortingelement("descending");
        sortingelement("low to high");
        sortingelement("high to low");



    }

    public  void sortingelement(String s){

        Select objSelect =new Select(driver.findElement(By.className("product_sort_container")));
//        objSelect.selectByIndex(3);

        switch (s){
            case "ascending" ->
                    objSelect.selectByIndex(0);

            case "descending" ->
                    objSelect.selectByIndex(1);
            case "lh" ->
                    objSelect.selectByIndex(2);
            case "hl" ->
                    objSelect.selectByIndex(3);

        }
    }



    public static void main(String[] args) {

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

//        Sorting obj = new Sorting();
        Sorting obj = new Sorting();

        obj.newfunction("standard_user","secret_sauce");

    } }
