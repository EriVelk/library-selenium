package com.example.firstplan;

import com.example.firstplan.utils.ConstantsTest;
import com.example.firstplan.utils.Utils;
import org.example.browser.Browser;
import org.example.controller.document.Document;
import org.example.controller.screen.Screenshot;
import org.example.model.CatalogModel;
import org.example.model.HomeModel;
import org.example.model.LoginModel;
import org.example.model.RegisterModel;
import org.example.utils.Constants;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestRegister {
    private HomeModel homeModel;
    Screenshot screenshot = new Screenshot();
    Document document = new Document();
    LinkedHashMap<String, File> captures = new LinkedHashMap<>();
    HashMap<String, String> errors = new HashMap<>();

    @BeforeAll
    void setUp(){
        Browser.getBrowser();
        this.homeModel = PageFactory.initElements(Browser.webDriver, HomeModel.class);
        captures.put("1. Open home", new File(screenshot.screenShoot(Browser.webDriver)));
        try{
            Assertions.assertTrue(homeModel.titleHeader.isDisplayed());
            Assertions.assertEquals("Library", Browser.webDriver.getTitle());
        }catch (AssertionError e){
            errors.put(Constants.assertionError, e.getMessage());
        }
    }

    @Test
    void test(){
        homeModel.register.click();

        RegisterModel registerModel = PageFactory.initElements(Browser.webDriver, RegisterModel.class);

        try{
            Assertions.assertEquals(ConstantsTest.titleRegister, registerModel.title.getText());
        }catch (AssertionError e){
            errors.put(Constants.assertionError, e.getMessage());
        }

        String email = "prueba2@hotmail.com";
        String password = "veliz1122";

        registerModel.name.sendKeys("Erick");
        registerModel.lastname.sendKeys("Veliz");
        registerModel.date.sendKeys("27041996");
        registerModel.email.sendKeys(email);
        registerModel.password.sendKeys(password);
        registerModel.conpassword.sendKeys(password);
        registerModel.btnRegister.click();

        LoginModel loginModel = PageFactory.initElements(Browser.webDriver, LoginModel.class);
        captures.put("2. Open login", new File(screenshot.screenShoot(Browser.webDriver)));

        try{
            Assertions.assertEquals(ConstantsTest.titleLogin, loginModel.titleLogin.getText());
        }catch (AssertionError e){
            errors.put(Constants.assertionError, e.getMessage());
        }

        loginModel.email.sendKeys(email);
        loginModel.password.sendKeys(password);
        loginModel.btnLogin.click();

        CatalogModel catalogModel = PageFactory.initElements(Browser.webDriver, CatalogModel.class);
        captures.put("3. Sign in", new File(screenshot.screenShoot(Browser.webDriver)));

        try{
            Assertions.assertTrue(catalogModel.logout.isDisplayed());
        }catch (AssertionError e){
            errors.put(Constants.assertionError, e.getMessage());
        }

        catalogModel.logout.click();
        try{
            Assertions.assertTrue(homeModel.titleHeader.isDisplayed());
        }catch (AssertionError e){
            errors.put(Constants.assertionError, e.getMessage());
        }
    }

    @AfterAll
    void quit(){
        document.create(Utils.nameClass(getClass().getName()), captures, errors);
        Browser.closeBrowser();
    }
}
