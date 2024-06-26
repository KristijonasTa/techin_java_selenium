package org.testing.exam;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{

    LoginPage loginPage;
    CalculatorHomePage calculatorHomePage;

    @Test
    void userCanLogin(){
        loginPage = new LoginPage(driver);
        calculatorHomePage = new CalculatorHomePage(driver);
        loginPage.setUserNameInput("NewUser");
        loginPage.setPasswordInput("password");
        loginPage.clickSubmitButton();

        String expectedNavBar = "Skaičiuotuvas jautrus neigiamiems skaičiams ;)";
        String actualNavBar = calculatorHomePage.getNavBarText();

        Assertions.assertThat(actualNavBar).isEqualTo(expectedNavBar);
    }

    @Test
    void incorrectLoginPassword() {
        loginPage = new LoginPage(driver);
        calculatorHomePage = new CalculatorHomePage(driver);
        loginPage.setUserNameInput("NewUser");
        loginPage.setPasswordInput("pas");
        loginPage.clickSubmitButton();

        String expectedNavBar = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";
        String actualNavBar = loginPage.getErrorMessageText();

        Assertions.assertThat(actualNavBar).isEqualTo(expectedNavBar);
    }
}
