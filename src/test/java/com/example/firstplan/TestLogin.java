package com.example.firstplan;

import com.example.firstplan.utils.Utils;
import org.example.browser.Browser;
import org.example.controller.document.Document;
import org.example.controller.screen.Screenshot;
import org.example.model.CatalogModel;
import org.example.model.HomeModel;
import org.example.model.LoginModel;
import org.example.utils.Constants;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestLogin {
    private HomeModel homeModel;
    Screenshot screenshot = new Screenshot();
    Document document = new Document();
    private final LinkedHashMap<String, File> captures = new LinkedHashMap<>();
    private final HashMap<String, String> errors = new HashMap<>();

    @BeforeAll
    void setUp(){
        Browser.getBrowser();
        this.homeModel = PageFactory.initElements(Browser.webDriver, HomeModel.class);
        captures.put("1. Open home", new File(screenshot.screenShoot(Browser.webDriver)));
        try{
            Assertions.assertTrue(homeModel.titleHeader.isDisplayed());
        }catch (AssertionError e){
            errors.put(Constants.assertionError, e.getMessage());
        }
    }

    @Test
    void test(){
        String email = "prueba@hotmail.com";
        String password = "veliz1122";

        try{
            Assertions.assertEquals("Librar", Browser.webDriver.getTitle());
        }catch (AssertionError e){
            errors.put(Constants.assertionError, e.getMessage());
        }

        homeModel.login.click();

        captures.put("2. Open login", new File(screenshot.screenShoot(Browser.webDriver)));

        LoginModel loginModel = PageFactory.initElements(Browser.webDriver, LoginModel.class);
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
        captures.put("4. Exit", new File(screenshot.screenShoot(Browser.webDriver)));
    }

    @AfterAll
    void quit(){
        document.create(Utils.nameClass(getClass().getName()), captures, errors);
        Browser.closeBrowser();
    }
}
