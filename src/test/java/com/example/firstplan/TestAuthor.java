package com.example.firstplan;

import com.example.firstplan.model.Author;
import com.example.firstplan.model.UserLogin;
import com.example.firstplan.model.UserRegister;
import com.example.firstplan.utils.Constants;
import org.example.browser.Browser;
import org.example.model.AuthorListModel;
import org.example.model.AuthorRegisterModel;
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@TestMethodOrder(OrderAnnotation.class)
public class TestAuthor {

    private HomeModel homeModel;
    private RegisterModel registerModel;
    private LoginModel loginModel;
    private CatalogModel catalogModel;
    private AuthorListModel authorListModel;
    private AuthorRegisterModel authorRegisterModel;

    @BeforeAll
    static void setUp(){
        Browser.getBrowser();
    }

    @Test
    @Order(1)
    void open(){
        this.homeModel = PageFactory.initElements(Browser.webDriver, HomeModel.class);
        Assertions.assertEquals(Constants.titleHome, homeModel.titleHeader.getText());
    }

    @Test
    @Order(2)
    void login(){
        this.homeModel = PageFactory.initElements(Browser.webDriver, HomeModel.class);
        homeModel.login.click();
        this.loginModel = PageFactory.initElements(Browser.webDriver, LoginModel.class);
        Assertions.assertEquals(Constants.titleLogin, loginModel.titleLogin.getText());
        loginModel.email.sendKeys(Constants.email);
        loginModel.password.sendKeys(Constants.password);
        loginModel.btnLogin.click();
    }

    @Test
    @Order(3)
    void create(){
        this.catalogModel = PageFactory.initElements(Browser.webDriver, CatalogModel.class);
        Assertions.assertEquals(Constants.titleCatalog, catalogModel.catlog.getText());
        catalogModel.menuAuthors.click();
        this.authorListModel = PageFactory.initElements(Browser.webDriver, AuthorListModel.class);
        Assertions.assertEquals(Constants.titleAuthorList,authorListModel.titleAuthors.getText());
        authorListModel.btnCreateAuthor.click();
        this.authorRegisterModel = PageFactory.initElements(Browser.webDriver, AuthorRegisterModel.class);
        Assertions.assertEquals(Constants.titleAuthorRegister, authorRegisterModel.titleCreateAuthor.getText());
        Author author = new Author("Rodrigo", "Estrada", "25111995");
        authorRegisterModel.firstName.sendKeys(author.getFirstName());
        authorRegisterModel.familyName.sendKeys(author.getFamilyName());
        authorRegisterModel.dateBirth.sendKeys(author.getDateBirth());
        authorRegisterModel.btnCreateAuthor.click();

        String path = "//a[text()='" + author.getFamilyName() + ", " + author.getFirstName() + "']";

        WebElement authorCard = Browser.webDriver.findElement(By.xpath(path));

        if (authorCard.isDisplayed())
            System.out.println("Se creo");
        else
            System.out.println("No lo encuentro");

        catalogModel.logout.click();
    }

    @AfterAll
    static void exit(){
        Browser.closeBrowser();
    }
}
