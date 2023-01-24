package org.example.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginModel {
    @FindBy(id="email")
    public WebElement email;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id = "btn-login")
    public WebElement btnLogin;

    @FindBy(id = "btn-register")
    public WebElement btnRegister;
}
