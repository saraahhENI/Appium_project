package pom;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PaymentPage {

    @SuppressWarnings("unused")
    private AndroidDriver driver;


    public PaymentPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Card Number* input field\"]")
    private WebElement paymentCardNumber;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\'Full Name* input field']")
    private WebElement paymentNameInput;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Expiration Date* input field\"]")
    private WebElement paymentExpirElement;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Security Code* input field\"]")
    private WebElement paymentSecureCodElement;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Review Order\"]")
    private WebElement paymentOrderSubmit;

    
    public void saisirNomComplet (String fullname) {        
        paymentNameInput.sendKeys(fullname);
    }     
    public void saisirCB (String cb) {    
        paymentCardNumber.sendKeys(cb);
    }     
    public void saisirExpDate (String date) {        
        paymentExpirElement.sendKeys(date);
    }     
    public void saisirCode (String code) {    
        paymentSecureCodElement.sendKeys(code);
    }     
    public void cliquerBtnReviewOrder () {
        paymentOrderSubmit.click();
    }

}
