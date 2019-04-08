import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class verifyLoginValidAndInvalidEXEL {

    Util util = new Util();
    WebDriver driver;
    PageLogin pageLogin;
    @BeforeClass
    public void setProperties(){
        System.setProperty(util.webDriverFireFoxInstanse,util.localFirefoxDriver2);
        driver = new FirefoxDriver();
        pageLogin = new PageLogin(driver);
    }

    @Test(priority = 0)
    public void login_validData(){
        driver.get(util.urlGuru99);

        pageLogin.getPasswArea().sendKeys(ReadEXEL.readExelFile(util.pathEXELFile,0,0,1));
        pageLogin.getUserIDArea().sendKeys(ReadEXEL.readExelFile(util.pathEXELFile,0,0,0));
        pageLogin.getLoginButton().click();
    }

    @Test(priority = 1)
    public void loginWith_invalid_UserID(){
        driver.navigate().to(util.urlGuru99);
        pageLogin.getUserIDArea().sendKeys(ReadEXEL.readExelFile(util.pathEXELFile,0,1,0));
        pageLogin.getPasswArea().sendKeys(ReadEXEL.readExelFile(util.pathEXELFile,0,0,1));
        pageLogin.getLoginButton().click();

        String alertMessege = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessege,util.messegeFromAlert);
        driver.switchTo().alert().accept();
    }

    @Test(priority = 2)
    public void logInWith_invalid_Password(){
        driver.navigate().to(util.urlGuru99);
        pageLogin.getUserIDArea().sendKeys(ReadEXEL.readExelFile(util.pathEXELFile,0,0,0));
        pageLogin.getPasswArea().sendKeys(ReadEXEL.readExelFile(util.pathEXELFile,0,1,1));
        pageLogin.getLoginButton().click();

        String alertMessege = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessege,util.messegeFromAlert);
        driver.switchTo().alert().accept();
    }

    @Test(priority = 3)
    public void loginWitn_Invlid_UserID_and_Invalid_Password(){
        driver.navigate().to(util.urlGuru99);
        pageLogin.getUserIDArea().sendKeys(ReadEXEL.readExelFile(util.pathEXELFile,0,1,0));
        pageLogin.getPasswArea().sendKeys(ReadEXEL.readExelFile(util.pathEXELFile,0,1,1));
        pageLogin.getLoginButton().click();

        String alertMessege = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessege,util.messegeFromAlert);
        driver.switchTo().alert().accept();
    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}
