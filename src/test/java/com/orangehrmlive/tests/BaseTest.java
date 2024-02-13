package com.orangehrmlive.tests;

import com.orangehrmlive.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import util.CommonUtil;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected EmployeePage employeePage;

    protected CommonUtil commonUtil;
    protected PersonalDetailsPage personalDetailsPage;
    protected JobPage jobPage;

    @Parameters("browser")
    @BeforeTest(alwaysRun = true)
    public void setupDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else System.out.println("Incorrect browser " + browser);

        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        employeePage = new EmployeePage(driver);
        personalDetailsPage = new PersonalDetailsPage(driver);
        jobPage = new JobPage(driver);
        commonUtil = new CommonUtil(driver);


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
