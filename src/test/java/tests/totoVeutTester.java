package tests;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class totoVeutTester {

   
    public static void main(String[] args) throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        // options.setUdid("ENUL630010");

        options.setCapability("appium:appPackage", "com.saucelabs.mydemoapp.rn");
        options.setCapability("appium:appActivity", ".MainActivity");
        options.setCapability("platformName", "Android");
        options.setCapability("appium:platformVersion", "14");
        options.setCapability("appium:automationName", "UiAutomator2");
        options.setCapability("appium:deviceName", "emulator-5554");
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        try {
            
            WebElement productItem = driver.findElement(AppiumBy.xpath(
              "//android.widget.TextView[@content-desc='store item text' and @text='Sauce Labs Backpack']"));
            productItem.click();
            WebElement redColorItem = driver.findElement(
                    AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"red circle\"]/android.view.ViewGroup"));
            redColorItem.click();
            WebElement plusBtnItem = driver.findElement(AppiumBy
                    .xpath("//android.view.ViewGroup[@content-desc=\"counter plus button\"]/android.widget.ImageView"));
            for (int i = 1; i < 12; i++) {
                plusBtnItem.click();
            }
            WebElement addItem = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Add To Cart\"]"));
            addItem.click();




            WebElement panierBtn = driver.findElement(
                    AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"cart badge\"]/android.widget.ImageView"));
            panierBtn.click();
            WebElement proceedToCheckBtn = driver
                    .findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Proceed To Checkout\"]"));
            proceedToCheckBtn.click();



            WebElement usernameLoginInput = driver
                    .findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Username input field\"]"));
            usernameLoginInput.sendKeys("bob@example.com");
            WebElement passwordLoginInput = driver
                    .findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Password input field\"]"));
            passwordLoginInput.sendKeys("10203040");
            WebElement LoginBtn = driver
                    .findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"Login button\"]"));
            LoginBtn.click();




            WebElement nameInput = driver
                    .findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc='Full Name* input field']"));
            nameInput.sendKeys("David");
            WebElement adresseInput = driver.findElement(
                    AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Address Line 1* input field\"]"));
            adresseInput.sendKeys("30 rue des colibri");
            WebElement cityInput = driver
                    .findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"City* input field\"]"));
            cityInput.sendKeys("Rennes");
            WebElement zipCodeInput = driver
                    .findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Zip Code* input field\"]"));
            zipCodeInput.sendKeys("35000");
            WebElement countryInput = driver
                    .findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Country* input field\"]"));
            countryInput.sendKeys("France");
            WebElement infoFormSubmitBtn = driver
                    .findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"To Payment\"]"));
            infoFormSubmitBtn.click();



            WebElement paymentCardNumber = driver.findElement(
                    AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Card Number* input field\"]"));
            paymentCardNumber.sendKeys("123456789321000");
            WebElement paymentNameInput = driver
                    .findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc=\'Full Name* input field']"));
            paymentNameInput.sendKeys("David");
            WebElement paymentExpirElement = driver.findElement(
                    AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Expiration Date* input field\"]"));
            paymentExpirElement.sendKeys("12/24");
            WebElement paymentSecureCodElement = driver.findElement(
                    AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Security Code* input field\"]"));
            paymentSecureCodElement.sendKeys("456");
            WebElement paymentOrderSubmit = driver
                    .findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Review Order\"]"));
            paymentOrderSubmit.click();



            
            WebElement placeOrderBtn = driver
                    .findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Place Order\"]"));
            placeOrderBtn.click();
            WebElement completedText = driver
                    .findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Checkout Complete\"]"));

            if ("Checkout Complete".equals(completedText.getText())) {
                System.out.println("Verification passed: Checkout is complete!");
            } else {
                System.err.println("Verification failed: Checkout is not complete!");
            }

        } finally {
            driver.quit();
        }
    }
}
