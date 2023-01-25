package org.example.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomeModel {
    @FindBy(id="login")
    public WebElement login;

    @FindBy(id = "register")
    public WebElement register;

    @FindBy(id = "link-github")
    public WebElement linkGithub;

    @FindBy(xpath = "//h1[@class='card-header' and text()='Library with NodeJS, Express, Authenticate-Passport, MongoDB and Bootstrap 5']")
    public WebElement titleHeader;
}
