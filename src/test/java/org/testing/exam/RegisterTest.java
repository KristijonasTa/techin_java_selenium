package org.testing.exam;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;


public class RegisterTest extends BaseTest{
    RegisterPage registerPage;
    LoginPage loginPage;

    CalculatorHomePage calculatorHomePage;

    @Test
    void userCanRegisterWithValidCredentials(){
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        calculatorHomePage = new CalculatorHomePage(driver);
        loginPage.clickRegisterLink();

        registerPage.setUserNameInput();
        registerPage.setPasswordInput("password");
        registerPage.setPasswordConfirmInput("password");
        registerPage.clickSubmitButton();

        String expectedNavBar = "Skaičiuotuvas jautrus neigiamiems skaičiams ;)";
        String actualNavBar = calculatorHomePage.getNavBarText();

        Assertions.assertThat(actualNavBar).isEqualTo(expectedNavBar);
    }

    @Test
    void userCanNotRegisterWithInvalidCredentials() {
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        loginPage.clickRegisterLink();

        registerPage.setUserNameInput();
        registerPage.setPasswordInput("pa");
        registerPage.setPasswordConfirmInput("pa");
        registerPage.clickSubmitButton();

        String expectedError = "Privaloma įvesti bent 3 simbolius";
        String actualError = registerPage.getInvalidPasswordText();

        Assertions.assertThat(actualError).isEqualTo(expectedError);
    }
}
