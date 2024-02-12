package com.orangehrmlive.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class EmployeePageTest extends BaseTest {

    @Parameters({"username", "password"})
    @Test(description = "Verify successful login with valid credentials", priority = 1)
    public void testLoginWithValidCredentials(String username, String password) {

        loginPage.navigateToLoginPage();
        loginPage.enterCredentialsAndLogin(username, password);

        assertTrue(dashboardPage.isDashboardContainerElementDisplayed(),
                "Dashboard container should be displayed after successful login.");
    }
    @Parameters({"firstName", "middleName", "lastName", "joinDate", "expectedToastMessage"})
    @Test(description = "Verify adding a new employee and check the popup message", priority = 2)
    public void testAddNewEmployee(String firstName, String middleName, String lastName, String joinDate,
                                   String expectedToastMessage) {

        dashboardPage.navigateToEmployeePage();
        employeePage.clickAddEmployeeButton();
        employeePage.fillNewEmployeeForm(firstName, middleName, lastName, joinDate);
        employeePage.clickOnNextButton(3);

        assertEquals(employeePage.getToastMessage(), expectedToastMessage,
                "Popup message should match the expected message after adding a new employee.");
        employeePage.waitForVueFormToLoad();
    }

    @Parameters({"firstName"})
    @Test(description = "Verify employee filter functionality", priority = 3)
    public void testEmployeeFilterFunctionality(String firstName) {

        dashboardPage.goToDashboard();
        employeePage.waitForVueFormToLoad();
        dashboardPage.navigateToEmployeePage();
        employeePage.enterSearchText(firstName);
        employeePage.waitForVueFormToLoad();
        employeePage.selectEmployeeFromSearchResults();
        employeePage.waitForVueFormToLoad();

        assertTrue(employeePage.getDisplayedEmployeeName().contains(firstName),
                "Displayed employee name should contain the searched first name.");
    }

    @Parameters({"expectedToastMessage"})
    @Test(description = "Verify uploading a user attachment", priority = 4)
    public void testUploadFileToPersonalDetails(String expectedToastMessage) {

        employeePage.goToEmployeeProfile();
        personalDetailsPage.navigateToPersonalDetailsPage();
        employeePage.waitForVueFormToLoad();
        personalDetailsPage.clickAddAttachmentButton();
        personalDetailsPage.uploadTextFile();
        personalDetailsPage.saveAttachment();

        assertTrue(employeePage.getToastMessage().contains(expectedToastMessage),
                "Popup message should contain the expected message after uploading a file.");
    }

    @Parameters({"expectedToastMessage"})
    @Test(description = "Verify terminate employment functionality", priority = 5)
    public void testTerminateEmployment(String expectedToastMessage) {

        employeePage.goToEmployeeProfile();
        jobPage.navigateToJobMenu();
        employeePage.waitForVueFormToLoad();
        jobPage.selectTerminateEmployee();
        employeePage.waitForVueFormToLoad();
        jobPage.fillTerminateEmploymentForm();
        employeePage.clickConfirmButton();

        assertEquals(employeePage.getToastMessage(), expectedToastMessage,
                "Popup message should match the expected message after terminating employment.");
    }
}
