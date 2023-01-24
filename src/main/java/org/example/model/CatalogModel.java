package org.example.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogModel {
    @FindBy(id = "catalog")
    public WebElement catlog;

    @FindBy(id = "logout")
    public WebElement logout;

    @FindBy(id = "books")
    public WebElement menuBooks;

    @FindBy(id = "authors")
    public WebElement menuAuthors;

    @FindBy(id = "genres")
    public WebElement menuGenres;

    @FindBy(id = "book-instances")
    public WebElement menuBookInstances;
}
