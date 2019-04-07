import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class VerifyLoginSection {

    PageLogin pageLogin;
    WebDriver driver;
    String pass;
    String userID;
    FileInputStream fileInputStream;
    Properties properties;
    File file;

    ProfilesIni profilesIni;
    FirefoxProfile firefoxProfile;
    Util util = new Util();

    @BeforeClass
    public void setprop(){
        System.setProperty(util.webDriverFireFoxInstanse,util.locationFierfoxdriver);

        //launch with fierfox profile;
        profilesIni = new ProfilesIni();
        firefoxProfile = profilesIni.getProfile("vhl232Test");
        //firefoxProfile = new FirefoxProfile(new File("C:\\Users\\Print\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\82456uip.vhl232Test"));
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setProfile(firefoxProfile);
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void startPage(){
        driver.get(util.urlGuru99);
    }

    @Test
    public void verifylogin(){
        properties = new Properties();

        try {
            file = new File(util.dataPathForGuru99);
            fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);

            userID = properties.getProperty("login");
            pass = properties.getProperty("password");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        pageLogin = new PageLogin(driver);

        pageLogin.getPasswArea().sendKeys(pass);
        pageLogin.getUserIDArea().sendKeys(userID);
        pageLogin.getLoginButton().click();
    }


    @Test
    public void verifyTitle(){
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,util.guruHomeTitle);

    }

    @AfterClass
    public void closetest(){
        driver.close();
    }
}
