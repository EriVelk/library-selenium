package org.example.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookListModel {
    @FindBy(id = "btn-create-book")
    WebElement btnCreateBook;

    @FindBy(xpath = "//h2[text()='Book List']")
    WebElement titleBooks;
}
