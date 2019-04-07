import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyLoginWithDataProvider {
    WebDriver driver;
    Util util = new Util();
    PageLogin pageLogin;

    @BeforeClass
    public void setProperties(){
        System.setProperty(util.webDriverFireFoxInstanse,util.localFirefoxDriver2);
        driver = new FirefoxDriver();
        pageLogin = new PageLogin(driver);
    }
    @Test(dataProvider = "dataFor_login",dataProviderClass = DataProviderClass.class )
    public void verifyLogin_dataProvider(String userID,String password){
        driver.navigate().to(util.urlGuru99);
        pageLogin.getUserIDArea().sendKeys(userID);
        pageLogin.getPasswArea().sendKeys(password);
        pageLogin.getLoginButton().click();

        String verifyManagePageTitle = driver.getTitle();
        System.out.println(verifyManagePageTitle);

        if(util.managerPageTitle.equalsIgnoreCase(verifyManagePageTitle)){
            WebElement table = driver.findElement(By.tagName("table"));
            WebElement rowTable = table.findElement(By.xpath("tbody/tr/td/table/tbody/tr[3]/td"));
            String manegeId = rowTable.getText();
            System.out.println(manegeId);
            Assert.assertEquals(manegeId,util.manage_USER_ID);
        }
        else {
            driver.navigate().to(util.urlGuru99);
            Assert.assertEquals(util.messegeFromAlert,driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
        }
    }


}
