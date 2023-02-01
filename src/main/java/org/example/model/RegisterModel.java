package org.example.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterModel {
    @FindBy(xpath = "//h4[@class='card-title text-center' and text()='Register']")
    public WebElement title;

    @FindBy(id="name")
    public WebElement name;

    @FindBy(id = "lastname")
    public WebElement lastname;

    @FindBy(id = "date")
    public WebElement date;

    @FindBy(id = "email")
    public WebElement email;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id = "conpassword")
    public WebElement conpassword;

    @FindBy(id="btn-register")
    public WebElement btnRegister;
}
