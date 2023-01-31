package com.example.firstplan;

import org.example.browser.Browser;
import org.example.controller.screen.Screenshot;
import org.example.model.CatalogModel;
import org.example.model.HomeModel;
import org.example.model.LoginModel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.LinkedHashMap;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestLogin {
    private HomeModel homeModel;
    private LoginModel loginModel;
    private CatalogModel catalogModel;
    Screenshot screenshot = new Screenshot();
    private LinkedHashMap<String, File> captures = new LinkedHashMap<>();

    @BeforeAll
    void setUp(){
        Browser.getBrowser();
        this.homeModel = PageFactory.initElements(Browser.webDriver, HomeModel.class);
        captures.put("1.Abre", new File(screenshot.screenShoot(Browser.webDriver)));
    }

    @Test
    void test(){
        String email = "prueba@hotmail.com";
        String password = "veliz1122";
        Assertions.assertEquals("Library", Browser.webDriver.getTitle());
        homeModel.login.click();
        captures.put("2.Abre Login", new File(screenshot.screenShoot(Browser.webDriver)));
        System.out.println(screenshot.screenShoot(Browser.webDriver));
        this.loginModel = PageFactory.initElements(Browser.webDriver, LoginModel.class);
        loginModel.email.sendKeys(email);
        loginModel.password.sendKeys(password);

        loginModel.btnLogin.click();
        this.catalogModel = PageFactory.initElements(Browser.webDriver, CatalogModel.class);
        captures.put("3.Entra sistema", new File(screenshot.screenShoot(Browser.webDriver)));
        Assertions.assertTrue(catalogModel.logout.isDisplayed());

        catalogModel.logout.click();
    }

    @AfterAll
    void quit(){
        Browser.closeBrowser();
    }
}
