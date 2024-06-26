package org.testing.exam;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//a[contains(text(),'Sukurti naują paskyrą')]")
    private WebElement registerLink;

    @FindBy(xpath="//input[@placeholder='Prisijungimo vardas']")
    private WebElement userNameInput;

    @FindBy(xpath="//input[@placeholder='Slaptažodis']")
    private WebElement passwordInput;


    @FindBy(xpath="//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath="//span[2]")
    private WebElement errorMessage;

    public void clickRegisterLink() {
        registerLink.click();
    }

    public void setUserNameInput(String username) {
        userNameInput.sendKeys(username);
    }

    public void setPasswordInput(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public String getErrorMessageText() {return errorMessage.getText();}
}
