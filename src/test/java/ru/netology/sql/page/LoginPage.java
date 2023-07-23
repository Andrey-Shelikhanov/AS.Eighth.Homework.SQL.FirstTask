package ru.netology.sql.page;

import ru.netology.sql.data.DataHelper;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement loginField = $("[data-test-id=login] input");

    private final SelenideElement passwordField = $("[data-test-id=password] input");

    private final SelenideElement loginButton = $("[data-test-id=action-login]");

    private final SelenideElement errorNotification = $("[data-test-id='error-notification']");

    public void verifyErrorNotificationVisibility() {
        errorNotification.shouldBe(visible);
    }

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }
}
