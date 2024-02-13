package com.orangehrmlive.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.CommonUtil;

public class EmployeePage extends BasePage {

    private final CommonUtil commonUtil;

    @FindBy(xpath = "//a[@id='addEmployeeButton']") protected WebElement addEmployeeButton;
    @FindBy(xpath = "//input[@id='first-name-box']") protected WebElement firstNameInput;
    @FindBy(xpath = "//input[@id='middle-name-box']") protected WebElement middleNameInput;
    @FindBy(xpath = "//input[@id='last-name-box']") protected WebElement lastNameInput;
    @FindBy(xpath = "//input[@name='dateTextInput']") protected WebElement joinDateTextInput;
    @FindBy(xpath = "//button[@data-id='location']") protected WebElement selectLocationDropdown;
    @FindBy(xpath = "//a[@id='bs-select-1-22']") protected WebElement selectLocationOption;
    @FindBy(xpath = "//button[@id='modal-save-button']") protected WebElement nextButton;
    @FindBy(xpath = "(//button[contains(@class,'btn-secondary right')])[1]") protected WebElement nextButtonSequence;
    @FindBy(xpath = "//button[@ng-show='vm.showFinishButton']") protected WebElement saveButton;
    @FindBy(xpath = "//div[@class='toast-message']") protected WebElement toastMessage;
    @FindBy(xpath = "(//input[contains(@id, filter_employee)])[2]") protected WebElement searchEmployeeInput;
    @FindBy(xpath = "(//span[@class='match'])[1]") protected WebElement selectEmployeeFromSearch;
    @FindBy(xpath = "(//a[contains(@ui-sref,'pim.employees.profile')])[3]") protected WebElement employeeName;

    public EmployeePage(WebDriver driver) {
        super(driver);
        this.commonUtil = new CommonUtil(driver);
    }

    public void clickAddEmployeeButton() {
        addEmployeeButton.click();
    }

    public void fillNewEmployeeForm(String firstName, String middleName, String lastName, String joinDate) {
        firstNameInput.sendKeys(firstName);
        middleNameInput.sendKeys(middleName);
        lastNameInput.sendKeys(lastName);
        joinDateTextInput.clear();
        joinDateTextInput.sendKeys(joinDate);
        selectLocationDropdown.click();
        commonUtil.scrollToElement(selectLocationOption);
        selectLocationOption.click();
        nextButton.click();
    }

    public void clickOnNextButton(int numberOfClicks) {
        for (int i = 0; i < numberOfClicks; i++) {
            commonUtil.waitForVueFToLoad();
            nextButtonSequence.click();
        }
        commonUtil.waitForVueFToLoad();
        saveButton.click();
    }

    public String getToastMessage() {
        return toastMessage.getText();
    }

    public void enterSearchText(String employeeName) {
        searchEmployeeInput.sendKeys(employeeName);
    }

    public void selectEmployeeFromSearchResults() {
        selectEmployeeFromSearch.click();
    }

    public String getSelectedEmployeeName() {
        return selectEmployeeFromSearch.getText();
    }

    public String getDisplayedEmployeeName() {
        return employeeName.getText();
    }

    public void goToEmployeeProfile() {
        employeeName.click();
    }

    public void clickConfirmButton() {
        nextButton.click();
    }
}
