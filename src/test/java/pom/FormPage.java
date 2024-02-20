package pom;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {

    @SuppressWarnings("unused")
    private AndroidDriver driver;
    
    public FormPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Full Name* input field']")
    private WebElement nameInput ;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Address Line 1* input field\"]")
    private WebElement adresseInput ;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"City* input field\"]")
    private WebElement cityInput ;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Zip Code* input field\"]")
    private WebElement zipCodeInput ;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"Country* input field\"]")
    private WebElement countryInput ;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"To Payment\"]")
    private WebElement infoFormSubmitBtn ;
    

    public void getName(String name) {
        nameInput.sendKeys(name);
    }  
    public void getAdress(String adresse) {
        adresseInput.sendKeys(adresse);
    }  
    public void getCity(String city) {
        cityInput.sendKeys(city);
    }  
    public void getZipCode(String code) {
        zipCodeInput.sendKeys(code);
    }  
    public void getCountry(String country) {
        countryInput.sendKeys(country);
    }  
    public void submitform(){
        infoFormSubmitBtn.click();
    } 
}
