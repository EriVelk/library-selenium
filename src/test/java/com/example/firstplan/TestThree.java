package com.example.firstplan;

import org.example.browser.Browser;
import org.example.model.CatalogModel;
import org.example.model.HomeModel;
import org.example.model.LoginModel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestThree {
    private Browser browser;
    private HomeModel homeModel;
    private LoginModel loginModel;
    private CatalogModel catalogModel;

    public TestThree() {
        this.browser = new Browser();
    }

    @BeforeAll
    void setUp(){
        browser.getBrowser();
        this.homeModel = PageFactory.initElements(browser.webDriver, HomeModel.class);
    }

    @Test
    void test(){
        String email = "prueba0@hotmail.com";
        String password = "veliz1122";
        Assertions.assertEquals("Library", browser.webDriver.getTitle());
        homeModel.login.click();
        this.loginModel = PageFactory.initElements(browser.webDriver, LoginModel.class);

        loginModel.email.sendKeys(email);
        loginModel.password.sendKeys(password);

        loginModel.btnLogin.click();

        this.catalogModel = PageFactory.initElements(browser.webDriver, CatalogModel.class);

        Assertions.assertTrue(catalogModel.logout.isDisplayed());

        catalogModel.logout.click();
    }

    @AfterAll
    void quit(){
        browser.closeBrowser();
    }
}
