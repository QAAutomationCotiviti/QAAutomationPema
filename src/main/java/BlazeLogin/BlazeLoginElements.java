package BlazeLogin;

import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import utilities.utility;

public class BlazeLoginElements {

    WebDriver driver;
    private final By loginBtn = By.id("login2");
    private final By userName = By.id("loginusername");
    private final By passWord = By.id("loginpassword");
    private final By logIn = By.xpath("//*[@onclick='logIn()']");
    private final By loginClose = By.xpath("//button[@class='btn btn-secondary']");

    public BlazeLoginElements(WebDriver driver) {
        this.driver = driver;
    }
    public void login(){
        driver.findElement(loginBtn).click();
    }
    public void loginForm(String username, String password){
//        utility.sleep();
//        driver.findElement(userName).sendKeys(username);
//        driver.findElement(passWord).sendKeys(password);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value = 'moonchild';", username);
        jsExecutor.executeScript("arguments[0].value = 'moon@123';", password);
    }
    public void loginClick(){
        driver.findElement(logIn).click();

    }
    public void loginClose(){
//        utility.sleep();
        JavascriptExecutor javaClose = (JavascriptExecutor) driver;
        javaClose.executeScript("arguments[0].click();",driver.findElement(loginClose));
        System.out.println("HELLO");

    }

}
