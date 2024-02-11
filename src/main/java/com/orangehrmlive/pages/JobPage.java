package com.orangehrmlive.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import util.CommonUtil;

public class JobPage extends BasePage {
    private final CommonUtil commonUtil;

    @FindBy(xpath = "//a[@data-automation-id='menu_employee_profile_Job']") protected WebElement jobMenuLink;
    @FindBy(xpath = "//a[contains(@ng-if,'termination_id')]") protected WebElement terminateEmployeeLink;
    @FindBy(xpath = "//button[@data-id='reason']") protected WebElement selectReasonButton;
    @FindBy(xpath = "//span[text()='Contract Not Renewed']") protected WebElement contractNotRenewedReason;
    @FindBy(xpath = "//span[text()='Terminate Now']") protected WebElement terminateNowCheckbox;

    public JobPage(WebDriver driver) {
        super(driver);
        this.commonUtil = new CommonUtil(driver);
    }

    public void navigateToJobMenu() {
        jobMenuLink.click();
    }

    public void selectTerminateEmployee() {
        commonUtil.scrollToElement(terminateEmployeeLink);
        terminateEmployeeLink.click();
    }

    public void fillTerminateEmploymentForm() {
        selectReasonButton.click();
        commonUtil.waitForElement(contractNotRenewedReason);
        contractNotRenewedReason.click();
        terminateNowCheckbox.click();
    }
}
