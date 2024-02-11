package com.orangehrmlive.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalDetailsPage extends BasePage {

    public final String UPLOAD_TXT_FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/TestUpload.txt";

    @FindBy(xpath = "//a[contains(@ui-sref, 'personal_details')]") protected WebElement personalDetailsLink;
    @FindBy(xpath = "//a[contains(@ng-click, 'addAttachments')]") protected WebElement addAttachmentButton;
    @FindBy(xpath = "//input[@id='filename']") protected WebElement addAttachmentInput;
    @FindBy(xpath = "//button[@id='modal-save-button']") protected WebElement saveButton;

    public PersonalDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToPersonalDetailsPage() {
        personalDetailsLink.click();
    }

    public void clickAddAttachmentButton() {
        addAttachmentButton.click();
    }

    public void uploadTextFile() {
        addAttachmentInput.sendKeys(UPLOAD_TXT_FILE_PATH);
    }

    public void saveAttachment() {
        saveButton.click();
    }
}