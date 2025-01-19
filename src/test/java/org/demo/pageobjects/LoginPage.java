package org.demo.pageobjects;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


/**
 * Page object for the login page.
 */
public class LoginPage {

    private SelenideElement loginHeading = $("div.login-wrapper h1").shouldBe(visible.because("Login heading is not visible"));
    private SelenideElement userLoginForm = $("form#userForm").shouldBe(visible.because("User login form is not visible"));
    private SelenideElement usernameField = userLoginForm.$("input#userName").shouldBe(visible.because("Username field is not visible"));
    private SelenideElement passwordField = userLoginForm.$("input#password").shouldBe(visible.because("Password field is not visible"));
    private SelenideElement loginButton = userLoginForm.$("button#login").shouldBe(visible.because("Login button is not visible"));


    /**
     * Login to the application.
     * @param username The username to login with.
     * @param password The password to login with.
     */
    public void login(String username, String password) {
        this.loginHeading.shouldBe(visible.because("Login heading is not visible"));
        this.usernameField.setValue(username);
        this.passwordField.setValue(password);
        this.loginButton.click();
    }

}
