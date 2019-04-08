import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScreensShots {
    WebDriver driver;
    Util util = new Util();
    PageLogin pageLogin;

    @BeforeClass
    public void setProperties(){
        System.setProperty(util.webDriverFireFoxInstanse,util.locationFierfoxdriver);
        driver = new FirefoxDriver();
        pageLogin = new PageLogin(driver);
    }
    @Test(dataProvider = "dataFor_login_Valid_Data",dataProviderClass = DataProviderClass.class )
    public void verifyLogin_dataProvider_Valid_Data(String userID,String password){
        driver.navigate().to(util.urlGuru99);
        pageLogin.getUserIDArea().sendKeys(userID);
        pageLogin.getPasswArea().sendKeys(password);
        pageLogin.getLoginButton().click();

        String verifyManagePageTitle = driver.getTitle();
        System.out.println(verifyManagePageTitle);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TakeShotClass.takeScreenShot(driver,util.filePathForScreens);

        WebElement table = driver.findElement(By.tagName("table"));
        WebElement rowTable = table.findElement(By.xpath("tbody/tr/td/table/tbody/tr[3]/td"));
        String manegeId = rowTable.getText();
        System.out.println(manegeId);
        Assert.assertEquals(manegeId,util.manage_USER_ID);


    }

    @Test(dataProvider = "data_Invalid_UserID",dataProviderClass = DataProviderClass.class)
    public void verify_login_with_invalid_UserID(String userID,String password){

        driver.navigate().to(util.urlGuru99);
        pageLogin.getUserIDArea().sendKeys(userID);
        pageLogin.getPasswArea().sendKeys(password);
        pageLogin.getLoginButton().click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TakeShotClass.takeScreenShot(driver,util.filePathForScreens);

        Assert.assertEquals(util.messegeFromAlert,driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @Test(dataProvider = "data_Invalid_Password",dataProviderClass = DataProviderClass.class)
    public void verify_login_with_invalid_Password(String userID,String password){

        driver.navigate().to(util.urlGuru99);
        pageLogin.getUserIDArea().sendKeys(userID);
        pageLogin.getPasswArea().sendKeys(password);
        pageLogin.getLoginButton().click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TakeShotClass.takeScreenShot(driver,util.filePathForScreens);

        Assert.assertEquals(util.messegeFromAlert,driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @Test(dataProvider = "data_Invalid_UserIDandPassword",dataProviderClass = DataProviderClass.class)
    public void verify_login_with_invalid_UserIDandPassword(String userID,String password){

        driver.navigate().to(util.urlGuru99);
        pageLogin.getUserIDArea().sendKeys(userID);
        pageLogin.getPasswArea().sendKeys(password);
        pageLogin.getLoginButton().click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TakeShotClass.takeScreenShot(driver,util.filePathForScreens);

        Assert.assertEquals(util.messegeFromAlert,driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}
