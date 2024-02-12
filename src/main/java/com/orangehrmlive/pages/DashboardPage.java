package com.orangehrmlive.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "(//a[@ui-sref='dashboard'])[1]") protected WebElement topBarDashboardElement;
    @FindBy(xpath = "//div[@class='dashboard-container']") protected WebElement dashboardContainerElement;
    @FindBy(xpath = "(//a[@data-automation-id='menu_pim_viewEmployeeList'])[1]") protected WebElement leftMenuEmployee;

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTopBarDashboardElementDisplayed() {
        return topBarDashboardElement.isDisplayed();
    }

    public String getTopBarDashboardElementText() {
        return topBarDashboardElement.getText();
    }

    public void navigateToEmployeePage() {
        leftMenuEmployee.click();
    }

    public void goToDashboard() {
        topBarDashboardElement.click();
    }
    public boolean isDashboardContainerElementDisplayed() {
        try {
            return dashboardContainerElement.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }
}