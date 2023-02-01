package com.example.firstplan;

import com.example.firstplan.model.UserLogin;
import com.example.firstplan.model.UserRegister;
import com.example.firstplan.utils.ConstantsTest;
import org.example.browser.Browser;
import org.example.model.CatalogModel;
import org.example.model.HomeModel;
import org.example.model.LoginModel;
import org.example.model.RegisterModel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.support.PageFactory;

@TestMethodOrder(OrderAnnotation.class)
public class TestRegisterAndLogin {
    private HomeModel homeModel;
    private RegisterModel registerModel;
    private LoginModel loginModel;
    private CatalogModel catalogModel;

    @BeforeAll
    static void setUp(){
        Browser.getBrowser();
    }

    @Test
    @Order(1)
    void testOpen(){
        this.homeModel = PageFactory.initElements(Browser.webDriver, HomeModel.class);
        Assertions.assertEquals(ConstantsTest.titleHome, homeModel.titleHeader.getText());
    }

    @Test
    @Order(2)
    void testRegister(){
        this.homeModel = PageFactory.initElements(Browser.webDriver, HomeModel.class);
        homeModel.register.click();
        this.registerModel = PageFactory.initElements(Browser.webDriver, RegisterModel.class);
        UserRegister userRegister = new UserRegister("Prueba", "Test", "20101995", "test@complete.com", "Prueba965", "Prueba965");

        registerModel.name.sendKeys(userRegister.getName());
        registerModel.lastname.sendKeys(userRegister.getLastName());
        registerModel.date.sendKeys(userRegister.getDate());
        registerModel.email.sendKeys(userRegister.getEmail());
        registerModel.password.sendKeys(userRegister.getPassword());
        registerModel.conpassword.sendKeys(userRegister.getConPassword());
        registerModel.btnRegister.click();
    }

    @Test
    @Order(3)
    void testLogin(){
        this.loginModel = PageFactory.initElements(Browser.webDriver, LoginModel.class);

        UserLogin userLogin = new UserLogin("test@complete.com", "Prueba965");

        loginModel.email.sendKeys(userLogin.getEmail());
        loginModel.password.sendKeys(userLogin.getPasssword());
        loginModel.btnLogin.click();

        this.catalogModel = PageFactory.initElements(Browser.webDriver, CatalogModel.class);
        Assertions.assertEquals(ConstantsTest.titleCatalog, catalogModel.catlog.getText());
        catalogModel.logout.click();
    }

    @AfterAll
    static void quit(){
        Browser.closeBrowser();
    }

}
