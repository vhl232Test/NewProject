import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin {
    WebDriver driver;

    @FindBy(name = "uid")
    WebElement userIDArea;
    @FindBy(name = "password")
    WebElement passwArea;
    @FindBy(name = "btnLogin")
    WebElement loginButton;

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getUserIDArea() {
        return userIDArea;
    }

    public WebElement getPasswArea() {
        return passwArea;
    }

    public PageLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
