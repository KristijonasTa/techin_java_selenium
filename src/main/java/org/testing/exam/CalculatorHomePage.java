package org.testing.exam;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CalculatorHomePage extends BasePage {
    @FindBy(xpath="//h3")
    private WebElement calculatorNavBarText;

    @FindBy(id = "sk1")
    private WebElement calculatorFirstNumber;

    @FindBy(id = "sk2")
    private WebElement calculatorSecondNumber;

    @FindBy(id = "sk2")
    private WebElement selectOperationDropdown;

    @FindBy(id = "sk1.errors")
    private WebElement firstNumberErrorMessage;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//h4")
    private WebElement answer;


    public CalculatorHomePage(WebDriver driver) {
        super(driver);
    }

    public String getNavBarText() {return calculatorNavBarText.getText();}

    public void setCalculatorFirstNumber(String firstNumber) {
        calculatorFirstNumber.clear();
        calculatorFirstNumber.sendKeys(firstNumber);
    }

    public void setCalculatorSecondNumber(String secondNumber) {
        calculatorSecondNumber.clear();
        calculatorSecondNumber.sendKeys(secondNumber);
    }

    public void setSelectOperation(String value) {
        Select selectOperation = new Select(driver.findElement(By.xpath("//select[@name='zenklas']")));
        selectOperation.selectByVisibleText(value);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public String getFirstNumberErrorMessage(){
        return firstNumberErrorMessage.getText();
    }

    public String getAnswer() {
        return answer.getText();
    }
}
