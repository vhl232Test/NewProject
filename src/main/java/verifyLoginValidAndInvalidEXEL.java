import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class verifyLoginValidAndInvalidEXEL {

    Util util = new Util();
    WebDriver driver;
    PageLogin pageLogin;
    @BeforeClass
    public void setProperties(){
        System.setProperty(util.webDriverFireFoxInstanse,util.locationFierfoxdriver);
        driver = new FirefoxDriver();
        pageLogin = new PageLogin(driver);
    }

    @Test(priority = 1)
    public void login_validData(){
        driver.get(util.urlGuru99);

        pageLogin.getPasswArea().sendKeys(ReadEXEL.readExelFile(util.pathEXELFile,0,0,1));
        pageLogin.getUserIDArea().sendKeys(ReadEXEL.readExelFile(util.pathEXELFile,0,0,0));
        pageLogin.getLoginButton().click();
    }

    @Test(priority = 2)
    public void loginWith_invalid_UserID(){
        driver.navigate().to(util.urlGuru99);
        pageLogin.getUserIDArea().sendKeys(ReadEXEL.readExelFile(util.pathEXELFile,0,1,0));
        pageLogin.getPasswArea().sendKeys(ReadEXEL.readExelFile(util.pathEXELFile,0,0,1));
        pageLogin.getLoginButton().click();
    }
}
