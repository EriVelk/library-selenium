package com.example.firstplan;

import org.example.browser.Browser;
import org.example.model.CatalogModel;
import org.example.model.HomeModel;
import org.example.model.LoginModel;
import org.example.model.RegisterModel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test02 {
    private Browser browser;
    private HomeModel homeModel;
    private LoginModel loginModel;
    private RegisterModel registerModel;
    private CatalogModel catalogModel;

    public Test02() {
        this.browser = new Browser();
    }

    @BeforeAll
    void setUp(){
        browser.getBrowser();
        this.homeModel = PageFactory.initElements(browser.webDriver, HomeModel.class);
    }

    @Test
    void test(){
        Assertions.assertEquals("Library", browser.webDriver.getTitle());
        homeModel.register.click();
        this.registerModel = PageFactory.initElements(browser.webDriver, RegisterModel.class);

        String email = "prueba2@hotmail.com";
        String password = "veliz1122";

        registerModel.name.sendKeys("Erick");
        registerModel.lastname.sendKeys("Veliz");
        registerModel.date.sendKeys("27041996");
        registerModel.email.sendKeys(email);
        registerModel.password.sendKeys(password);
        registerModel.conpassword.sendKeys(password);
        registerModel.btnRegister.click();

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
