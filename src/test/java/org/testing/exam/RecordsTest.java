package org.testing.exam;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RecordsTest extends BaseTest{
    LoginPage loginPage;
    CalculatorHomePage calculatorHomePage;
    RecordsPage recordsPage;

    @Test
    void userCanDeleteRecords(){
        loginPage = new LoginPage(driver);
        calculatorHomePage = new CalculatorHomePage(driver);
        recordsPage = new RecordsPage(driver);

        loginPage.setUserNameInput("NewUser");
        loginPage.setPasswordInput("password");
        loginPage.clickSubmitButton();

        String expectedNavBar = "Skaičiuotuvas jautrus neigiamiems skaičiams ;)";
        String actualNavBar = calculatorHomePage.getNavBarText();

        Assertions.assertThat(actualNavBar).isEqualTo(expectedNavBar);

        recordsPage.clickOperationRecordsLink();

        recordsPage.clickShowFirstRecordDetails();
        String beforeDeletion = recordsPage.getFirstRecordId();
        recordsPage.clickOperationRecordsLink();
        recordsPage.clickDeleteFirstRecord();
        recordsPage.clickShowFirstRecordDetails();
        String afterDeletion = recordsPage.getFirstRecordId();

        Assertions.assertThat(beforeDeletion).isNotEqualTo(afterDeletion);
    }
    @Test
    void userCanNotEditNegativeNumberInRecords(){
        loginPage = new LoginPage(driver);
        calculatorHomePage = new CalculatorHomePage(driver);
        recordsPage = new RecordsPage(driver);

        loginPage.setUserNameInput("NewUser");
        loginPage.setPasswordInput("password");
        loginPage.clickSubmitButton();

        String expectedNavBar = "Skaičiuotuvas jautrus neigiamiems skaičiams ;)";
        String actualNavBar = calculatorHomePage.getNavBarText();

        Assertions.assertThat(actualNavBar).isEqualTo(expectedNavBar);

        recordsPage.clickOperationRecordsLink();
        recordsPage.clickChangeFirstRecordDetails();
        recordsPage.setFirstNumberInRecords("-1");
        recordsPage.clickChangeFirstRecord();

        String expectedResult = "Whitelabel Error Page";
        String actualResult = recordsPage.getErrorPageMessage();

        Assertions.assertThat(actualResult).isEqualTo(expectedResult);

    }
}
