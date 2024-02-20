package pom;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HomePage {
    public AndroidDriver driver;

    public HomePage(AndroidDriver driver){
        this.driver = driver;
    } 

}
