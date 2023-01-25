package com.example.firstplan;

import org.example.browser.Browser;
import org.example.model.HomeModel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;

/**
 * Este test
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Test01 {
    private Browser browser;
    private HomeModel homeModel;

    public Test01() {
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
    }

    @AfterAll
    void quit(){
        browser.closeBrowser();
    }
}
