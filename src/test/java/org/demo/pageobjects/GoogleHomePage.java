package org.demo.pageobjects;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


public class GoogleHomePage {

    SelenideElement searchBox = $("textarea[title='Search']");
    SelenideElement searchButton = $("input[value='Google Search']");


    /**
     * Search for the given text.
     * @param searchText text to search
     */
    public void searchFor(String searchText) {
        searchBox.setValue(searchText);
        searchButton.click();
    }
}
