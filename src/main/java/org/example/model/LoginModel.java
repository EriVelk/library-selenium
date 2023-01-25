package org.example.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginModel {
    @FindBy(id="email") //XPath = //input[@id='email' and @name='email']
    public WebElement email;

    @FindBy(id="password") //XPath = //input[@id='password' and @name='password']
    public WebElement password;

    @FindBy(id = "btn-login") //XPath = //button[@id='btn-login' and @name='btn-login']
    public WebElement btnLogin;

    @FindBy(id = "btn-register") //XPath = //button[@id='btn-register' and @name='btn-register']
    public WebElement btnRegister;

    @FindBy(xpath = "//h4[text()='Log In']")
    public WebElement titleLogin;
}
