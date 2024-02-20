package pom;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage {

    @SuppressWarnings("unused")
    private AndroidDriver driver;
    
    public CartPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @CacheLookup
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView")
    private WebElement panierBtn;
     
    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Proceed To Checkout\"]")
    private WebElement proceedToCheckBtn;
    
    public void selectionner_panier(){
        panierBtn.click();
    }       
    public void selectionner_proceed_to_check(){
        proceedToCheckBtn.click();
    }       
        
}

