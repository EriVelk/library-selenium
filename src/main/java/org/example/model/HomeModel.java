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

    @FindBy(tagName = "a")
    public List<WebElement> lista;
}
