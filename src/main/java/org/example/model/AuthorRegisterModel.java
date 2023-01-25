package org.example.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorRegisterModel {
    @FindBy(id = "first_name")
    public WebElement firstName;

    @FindBy(id="family_name")
    public WebElement familyName;

    @FindBy(id = "date_of_birth")
    public WebElement dateBirth;

    @FindBy(id = "date_of_death")
    public WebElement dateDeath;

    @FindBy(id="btn-register-author")
    public WebElement btnCreateAuthor;

    @FindBy(xpath = "//h2[text()='Register Author']")
    public WebElement titleCreateAuthor;
}
