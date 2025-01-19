package org.demo.pageobjects;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;


public class GoogleResultPage {

    SelenideElement firstResult = $("h3");


    /**
     * Get the text of the first result.
     * @return text of the first result
     */
    public String getFirstResultText() {
        System.out.println( "First search result is ---- "+firstResult.getText());
        return firstResult.getText();
    }
}
