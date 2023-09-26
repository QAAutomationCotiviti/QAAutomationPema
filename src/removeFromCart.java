import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class removeFromCart{
    static WebDriver driver= new ChromeDriver();

    public void newfunction(String s, String p) {

        WebElement user = driver.findElement(By.id("user-name"));
        user.sendKeys(s);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(p);

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        addremoveCart();


    }
    public void addremoveCart(){

        WebElement beforecart=driver.findElement(By.className("inventory_item_name"));
        String name = beforecart.getText();

        WebElement cart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        cart.click();

        WebElement addedElement= driver.findElement(By.className("shopping_cart_link"));
        addedElement.click();

        WebElement element1 = driver.findElement(By.className("inventory_item_name"));
        String Name = element1.getText();

        if(name.equals(Name)){
            System.out.println("Added to cart Sucessfully");
        }
        else {
            System.out.println("Error adding to cart");
        }

        WebElement remove= driver.findElement(By.id("remove-sauce-labs-backpack"));
        remove.click();
        System.out.println("Removed from cart");


    }


    public static void main(String[] args) {

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

//        Sorting obj = new Sorting();
        removeFromCart myObj = new removeFromCart();

        myObj.newfunction("standard_user","secret_sauce");
//        myObj.newfunction("standard_user","secret_sauce");

    } }

