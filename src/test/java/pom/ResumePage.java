    package pom;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ResumePage {

    @SuppressWarnings("unused")
    private AndroidDriver driver;
    
    public ResumePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Place Order\"]")
    private WebElement placeOrderBtn;
    
    public void selectionner_place_order(){
        placeOrderBtn.click();
    } 
    
}

