package org.testing.exam;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
    Faker faker = new Faker();
    String userName = faker.name().username();
    @FindBy(id="username")
    private WebElement userNameInput;
    @FindBy(id="password")
    private WebElement passwordInput;
    @FindBy(id="passwordConfirm")
    private WebElement passwordConfirmInput;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;


    @FindBy(id="password.errors")
    private WebElement invalidPasswordText;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void setUserNameInput() { userNameInput.sendKeys(userName);}
    public void setPasswordInput(String password) { passwordInput.sendKeys(password);}
    public void setPasswordConfirmInput(String password) { passwordConfirmInput.sendKeys(password);}
    public void clickSubmitButton(){
        submitButton.click();
    }

    public String getInvalidPasswordText() {return invalidPasswordText.getText();}

}
