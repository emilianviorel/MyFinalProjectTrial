package com.orangehrmlive.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "(//a[@ui-sref='dashboard'])[1]") protected WebElement dashboardHomeIconElement;
    @FindBy(xpath = "(//a[@data-automation-id='menu_pim_viewEmployeeList'])[1]") protected WebElement leftMenuEmployee;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayedDashboardHomeIconElement() {
        return dashboardHomeIconElement.isDisplayed();
    }

    public String getTextDashboardHomeIconElement() {
        return dashboardHomeIconElement.getText();
    }

    public void navigateToEmployeeListPage() {
        leftMenuEmployee.click();
    }

    public void goToDashboard() {
        dashboardHomeIconElement.click();
    }
}
