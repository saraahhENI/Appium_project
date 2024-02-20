package pom;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
    
    @SuppressWarnings("unused")
    private AndroidDriver driver;
    
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Username input field\"]")
    private WebElement usernameLoginInput;
     
    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Password input field\"]")
    private WebElement passwordLoginInput;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Login button\"]")
    private WebElement LoginBtn;
    
    public void selectionner_login(){
        LoginBtn.click();
    }       

    public void typePassword(String password) {
        passwordLoginInput.sendKeys(password);
    }  

    public void typeUsername(String username) {
        usernameLoginInput.sendKeys(username);
    }  
  
    public void seConnecter (String username, String password){
        passwordLoginInput.sendKeys(password);
        usernameLoginInput.sendKeys(username);
        LoginBtn.click();
    }
    
}
