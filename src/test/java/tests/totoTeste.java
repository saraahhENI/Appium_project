package tests;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.Test;

import Utils.config;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pom.*;

public class totoTeste {

    AppiumDriverLocalService service;
    AndroidDriver driver;

    @Test
    public void myFirstBags() throws MalformedURLException{
       
        startAppiumServer();
        startEmulatorSession();

        ProductsPage pp = new ProductsPage(driver);
        CartPage cp = new CartPage(driver);
        LoginPage lp = new LoginPage(driver);
        FormPage fp = new FormPage(driver);
        PaymentPage payp = new PaymentPage(driver);
        ResumePage rp = new ResumePage(driver);
        ConfirmPage confp = new ConfirmPage(driver);

        pp.selectionner_article();
    
        for(int i = 0; i<12; i++){
            pp.selectionner_article_more();
        }
        pp.selectionner_article_color();
        pp.selectionner_add_to_cart();

        cp.selectionner_panier();
        cp.selectionner_proceed_to_check();

        lp.seConnecter("bob@example.com", "10203040");

        fp.getName("Lola");
        fp.getAdress("39 rue des roses");
        fp.getCity("Rennes");
        fp.getZipCode("35000");
        fp.getCountry("France");
        fp.submitform();

        payp.saisirCB("123412341234789");
        payp.saisirNomComplet("lolo denis");
        payp.saisirExpDate("12/24");
        payp.saisirCode("654");
        payp.cliquerBtnReviewOrder();

        rp.selectionner_place_order();

        boolean rep = confp.verifierConfirmationAchat();
        if(rep){
            System.out.println("Vos douze sacs arrivent bientôt !");
        } else {
            System.out.println("Il me semble qu'il y a un problème ...");
        }
        driver.quit();
    }

    public void startEmulatorSession() throws MalformedURLException {
        
        UiAutomator2Options options = new UiAutomator2Options();
        // options.setUdid("ENUL630010");

        options.setCapability("appium:appPackage", "com.saucelabs.mydemoapp.rn");
        options.setCapability("appium:appActivity", ".MainActivity");
        options.setCapability("platformName", "Android");
        options.setCapability("appium:platformVersion", "14");
        options.setCapability("appium:automationName", "UiAutomator2");
        options.setCapability("appium:deviceName", "emulator-5554");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }

    public AppiumDriverLocalService startAppiumServer() { 
        boolean running = isServerRunning(config.appiumPort);
        if (!running) {
            service = new AppiumServiceBuilder()
                .withAppiumJS(new File(config.appiumJSExecutor))
                .withIPAddress(config.appiumServer)
                .withLogFile(new File(config.appiumLog))
                .withTimeout(Duration.ofSeconds(config.appiumServerTimeOut))
                .usingPort(config.appiumPort).build();
            service.start();
        }
        return service;
    }
    public boolean isServerRunning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSock;
        try {
            serverSock = new ServerSocket(port);
            System.out.println("serverSock :"+ serverSock);
            serverSock.close();
        } catch (IOException e) {
            isServerRunning = true;
        } finally {
            serverSock = null;
        }
        return isServerRunning;
    }

}
