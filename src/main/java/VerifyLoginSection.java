import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class VerifyLoginSection {

    PageLogin pageLogin;
    WebDriver driver;
    String pass;
    String userID;
    FileInputStream fileInputStream;
    Properties properties;
    File file;
    String guruHome = "Guru99 Bank Home Page";
    @BeforeClass
    public void setprop(){
        System.setProperty("webdriver.gecko.driver","D:\\geckodriver-v0.24.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://www.demo.guru99.com/V4/");

        pageLogin = new PageLogin(driver);
        properties = new Properties();
        try {
            file = new File("src/main/resources/Data.properties");
            fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);

           userID = properties.getProperty("login");
           pass = properties.getProperty("password");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void verifylogin(){
        pageLogin.getPasswArea().sendKeys(pass);
        pageLogin.getUserIDArea().sendKeys(userID);
        pageLogin.getLoginButton().click();
    }
    @Test
    public void verifyTitle(){
        String title = driver.getTitle();
        Assert.assertEquals(title,guruHome);

    }

    @AfterClass
    public void closetest(){
        driver.close();
    }
}
