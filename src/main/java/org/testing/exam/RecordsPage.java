package org.testing.exam;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RecordsPage extends BasePage{

    @FindBy(xpath = "//a[normalize-space()='Atliktos operacijos']")
    public WebElement operationRecordsLink;

    @FindBy(xpath = "//tbody/tr[2]/td[5]/a[normalize-space()='Trinti'][1]")
    public WebElement deleteFirstRecordButton;

    @FindBy(xpath = "//tbody/tr[2]/td[5]/a[normalize-space()='Rodyti'][1]")
    public WebElement showFirstRecordDetailsButton;

    @FindBy(xpath = "//tbody/tr[2]/td[5]/a[normalize-space()='Keisti'][1]")
    public WebElement changeFirstRecordDetailsButton;

    @FindBy(xpath = "//input[@name='sk1']")
    public WebElement changeFirstRecordFirstNumber;


    @FindBy(xpath = "//input[@value='Atnaujinti']")
    public WebElement submitChangeOfFirstRecord;

    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    public WebElement showFirstRecordId;

    @FindBy(xpath = "//h1")
    public WebElement errorPageMessage;

    public RecordsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOperationRecordsLink(){
        operationRecordsLink.click();
    }

    public void clickDeleteFirstRecord(){
        deleteFirstRecordButton.click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public void clickShowFirstRecordDetails(){
        showFirstRecordDetailsButton.click();
    }

    public void clickChangeFirstRecordDetails() {
        changeFirstRecordDetailsButton.click();
    }

    public void setFirstNumberInRecords(String number){
        changeFirstRecordFirstNumber.clear();
        changeFirstRecordFirstNumber.sendKeys(number);
    }

    public void clickChangeFirstRecord(){
        submitChangeOfFirstRecord.click();
    }

    public String getErrorPageMessage(){
        return errorPageMessage.getText();
    }

    public String getFirstRecordId(){
        return showFirstRecordId.getText();
    }

}
