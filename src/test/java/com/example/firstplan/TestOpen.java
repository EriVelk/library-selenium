package com.example.firstplan;

import com.example.firstplan.utils.Utils;
import org.example.browser.Browser;
import org.example.controller.document.Document;
import org.example.controller.screen.Screenshot;
import org.example.model.HomeModel;
import org.example.utils.Constants;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Este test
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestOpen {
    Screenshot screenshot = new Screenshot();
    Document document = new Document();
    LinkedHashMap<String, File> captures = new LinkedHashMap<>();
    HashMap<String, String> errors = new HashMap<>();

    @BeforeAll
    void setUp(){
        Browser.getBrowser();
        try{
            Assertions.assertEquals("Library", Browser.webDriver.getTitle());
        }catch (AssertionError e){
            errors.put(Constants.assertionError, e.getMessage());
        }
    }

    @Test
    void test(){
        HomeModel homeModel = PageFactory.initElements(Browser.webDriver, HomeModel.class);
        captures.put("1. Open home", new File(screenshot.screenShoot(Browser.webDriver)));
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
