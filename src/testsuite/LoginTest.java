package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void setup() {
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully (){
        //click on the Sign in link
        driver.findElement(By.xpath("//li[@class ='header__nav-item header__nav-sign-in']")).click();
        //Verify the text ‘Welcome Back!’
     String expectedMessage = "Welcome Back!";
       //Xpath for “Welcome Back!”
       WebElement actualTextElements = driver.findElement(By.xpath("//h2[@class = 'page__heading']"));

       String actualMessage = actualTextElements.getText();//comparing actualMessage with expectedMessage
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void verifyTheErrorMessage(){
        //click on the 'Sign in' link
        driver.findElement(By.xpath("//li[@class ='header__nav-item header__nav-sign-in']")).click();

        driver.findElement(By.id("user[email]")).sendKeys("Boss123@gmail.com"); //Enter username
        driver.findElement(By.id("user[password]")).sendKeys("secret"); //Enter password
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();

        //Verify the errorMessage 'Invalid email or password.'
        String expectedErrorMessage = "Invalid email or password.";
        //Xpath for “Invalid email or password.”
        WebElement actualTextElements = driver.findElement(By.xpath("//li[@class = 'form-error__list-item']"));

       String actualMessage = actualTextElements.getText();//comparing actualMessage with expectedMessage
       Assert.assertEquals(expectedErrorMessage, actualMessage);
    }
    @After
    public void testDown() {

        closeBrowser();
    }

}
