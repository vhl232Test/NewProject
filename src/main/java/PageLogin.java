import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin {
    WebDriver driver;

    @FindBy(name = "uid")
    private WebElement userIDArea;
    @FindBy(name = "password")
    private WebElement passwArea;
    @FindBy(name = "btnLogin")
    private WebElement loginButton;

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
