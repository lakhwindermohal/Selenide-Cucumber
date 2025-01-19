package org.demo.stepdefinitions;

import com.codeborne.selenide.Selenide;
import java.util.HashMap;
import org.demo.common.JsonUtilities;
import org.demo.pageobjects.GoogleHomePage;
import org.demo.pageobjects.GoogleResultPage;
import org.demo.pageobjects.LoginPage;
import org.junit.Assert;


public class CommonSteps {

    HashMap<String, Object> testData = JsonUtilities.fetchValuesFromJson("TestData.json");
    private final String URL = testData.get("url").toString();

    public CommonSteps() throws Exception {
    }


    /**
     * Open the URL.
     */
    public void openURL() {
        Selenide.open(URL);
    }


    /**
     * Login to the application.
     */
    public void loginToApplication() {
        LoginPage loginPage = new LoginPage();
        loginPage.login(testData.get("firstname").toString(), testData.get("lastname").toString());
    }


    /**
     * Search on Google.
     * @param searchText text to search
     */
    public void searchOnGoogle(String searchText) {
        GoogleHomePage googleHomePage = new GoogleHomePage();
        googleHomePage.searchFor(searchText);
    }


    public void verifyTopResult(String expectedText) {
        GoogleResultPage googleResultPage = new GoogleResultPage();
        String actualText = googleResultPage.getFirstResultText();
        Assert.assertEquals(expectedText, actualText);
    }
}
