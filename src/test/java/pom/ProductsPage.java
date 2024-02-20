package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductsPage {

    @SuppressWarnings("unused")
    private AndroidDriver driver;

    public ProductsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='store item text' and @text='Sauce Labs Backpack']")
    private WebElement productItem;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"red circle\"]/android.view.ViewGroup")
    private WebElement redColorItem;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"counter plus button\"]/android.widget.ImageView")
    private WebElement plusBtnItem;

    @CacheLookup
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Add To Cart\"]")
    private WebElement addItem;

    public void selectionner_article() {
        productItem.click();
    }

    public void selectionner_article_color() {
        redColorItem.click();
    }

    public void selectionner_article_more() {
        plusBtnItem.click();
    }

    public void selectionner_add_to_cart() {
        addItem.click();
    }
}
