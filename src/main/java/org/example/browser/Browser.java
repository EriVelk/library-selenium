package org.example.browser;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {

    public static WebDriver webDriver;
    private static final String url = "https://library-5ea0.onrender.com/";

    //private static final String url = "http://localhost:3000/";
    public static void getBrowser(){
        String pathDriver = "D:\\Erick_Trabajo\\Desktop\\Tecnologias\\Testing\\Java\\Selenium\\Library\\library\\src\\main\\resources\\driver\\msedgedriver.exe";
        System.setProperty("webdriver.edge.driver", pathDriver);
        webDriver = new EdgeDriver();
        webDriver.get(url);
        //webDriver.manage().window().maximize();
        webDriver.manage().window().setSize(new Dimension(1100, 959));
    }

    public static void closeBrowser(){
        webDriver.quit();
    }
}
