package org.testing.exam;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest extends BaseTest {
    LoginPage loginPage;
    CalculatorHomePage calculatorHomePage;

    @Test
    public void userCanMultiply(){
        loginPage = new LoginPage(driver);
        calculatorHomePage = new CalculatorHomePage(driver);

        loginPage.setUserNameInput("NewUser");
        loginPage.setPasswordInput("password");
        loginPage.clickSubmitButton();

        calculatorHomePage.setCalculatorFirstNumber("4");
        calculatorHomePage.setCalculatorSecondNumber("5");
        calculatorHomePage.setSelectOperation("Daugyba");
        calculatorHomePage.clickSubmitButton();

        String expectedResult = "4 * 5 = 20";
        String actualResult = calculatorHomePage.getAnswer();

        Assertions.assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void userCanNotUseNegativeNumbers(){
        loginPage = new LoginPage(driver);
        calculatorHomePage = new CalculatorHomePage(driver);

        loginPage.setUserNameInput("NewUser");
        loginPage.setPasswordInput("password");
        loginPage.clickSubmitButton();

        calculatorHomePage.setCalculatorFirstNumber("-1");
        calculatorHomePage.setCalculatorSecondNumber("2");
        calculatorHomePage.setSelectOperation("Atimtis");
        calculatorHomePage.clickSubmitButton();

        String expectedResult = "Validacijos klaida: skaičius negali būti neigiamas";
        String actualResult = calculatorHomePage.getFirstNumberErrorMessage();

        Assertions.assertThat(actualResult).isEqualTo(expectedResult);
    }
}
