package com.example.firstplan;

import org.example.browser.Browser;
import org.example.model.HomeModel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;

/**
 * Este test
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestOpen {
    private Browser browser;
    private HomeModel homeModel;

    public TestOpen() {
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
