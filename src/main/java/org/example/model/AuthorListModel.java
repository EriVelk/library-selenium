package org.example.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthorListModel {
    @FindBy(xpath = "//h2[text()='Author List']")
    public WebElement titleAuthors;

    @FindBy(id = "btn-create-author")
    public WebElement btnCreateAuthor;
}
