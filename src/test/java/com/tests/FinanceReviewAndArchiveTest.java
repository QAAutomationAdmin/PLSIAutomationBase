package com.tests;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.pom.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Listeners({com.listeners.ListenerTest.class})
public class FinanceReviewAndArchiveTest extends BaseClass{


    @Test(description = "This TC will perform valid login and navigated to finance archive page and approve one pending status")
    public void approveFinancialArchivePendingAppointment() throws Throwable {

        driver.get("http://qa.ims.client.sstech.us/login");
        LoginPage lo = new LoginPage(driver);
        FinancialAdminDashboardPage financialAdminPage=new FinancialAdminDashboardPage(driver);

        logger = extent.createTest(BaseClass.getMethodName() + "method started");

        lo.doLogin(datasheet.get("UserName"),datasheet.get("Password"));
        logger.addScreenCaptureFromPath(takeScreenshotForStep("Home Page"));
        logger.log(Status.PASS, "Login Clicked");
        Thread.sleep(2000);

          boolean isSelected =  financialAdminPage.navigateFinancialArchivePage();
          if(!isSelected)
            {
                WebElement el = financialAdminPage.getArchivetab();
                String timeStamp = new SimpleDateFormat("dd-MM-YYYY_HH-mm-ss").format(new Date());
                logger.addScreenCaptureFromPath(takeScreenshotForStep("taking screenshot"+timeStamp+".png",el));
                Assert.assertTrue(false,"Tab not highlighted");

            }

        Thread.sleep(5000);
          boolean found = false;
        try {
            DashBoardPage db = new DashBoardPage(driver);
          found =  financialAdminPage.approvingFinancialAppointment(1,"Pending");
        } catch (Throwable e) {
            logger.log(Status.FAIL,e.getMessage());
            logger.addScreenCaptureFromPath(takeScreenshotForStep("Pending Appointment to be clicked"));
        }
        try {
            if(found) {
                financialAdminPage.clickApproveButton();
                logger.addScreenCaptureFromPath(takeScreenshotForStep("After Approved the pending appointment"));
            }
        }catch (Throwable e){
            logger.log(Status.FAIL,e.getMessage());
            logger.addScreenCaptureFromPath(takeScreenshotForStep("pending appointment process for error"));
        }

      lo.click_logOut();
    }


    @Test
    public void sortingColumnsFinancialArchive() throws Throwable{

        driver.get("http://qa.ims.client.sstech.us/login");
        LoginPage lo = new LoginPage(driver);
        FinancialAdminPage FA=new FinancialAdminPage(driver);
        FinancialArchivePage columns = new FinancialArchivePage(driver);

        logger = extent.createTest(BaseClass.getMethodName() + "method started");

        lo.doLogin(datasheet.get("UserName"),datasheet.get("Password"));
        logger.addScreenCaptureFromPath(takeScreenshotForStep("Home Page"));
        logger.log(Status.PASS, "Login Clicked");
        Thread.sleep(2000);

        boolean isSelected =  FA.navigateFinancialArchivePage();
        if(!isSelected)
        {
            WebElement el = FA.getArchivetab();
            String timeStamp = new SimpleDateFormat("dd-MM-YYYY_HH-mm-ss").format(new Date());
            logger.addScreenCaptureFromPath(takeScreenshotForStep("taking screenshot"+timeStamp+".png",el));


        }

        Thread.sleep(5000);
        try {
            columns.sortColumnsFinancialArchive();
        } catch (Throwable e) {
            logger.log(Status.FAIL,e.getMessage());
            logger.addScreenCaptureFromPath(takeScreenshotForStep("Sorted Columns"));
        }
        lo.click_logOut();

    }

    @Test(description = "This TC will perform valid login and navigated to finance review page and approve one pending status")
    public void approveFinancialReviewPendingAppointment() throws Throwable {


        driver.get("http://qa.ims.client.sstech.us/login");
        LoginPage lo = new LoginPage(driver);
        FinancialAdminPage financialAdmin=new FinancialAdminPage(driver);

        logger = extent.createTest(BaseClass.getMethodName() + "method started");

        lo.doLogin(datasheet.get("UserName"),datasheet.get("Password"));
        logger.addScreenCaptureFromPath(takeScreenshotForStep("Home Page"));
        logger.log(Status.PASS, "Login Clicked");
        Thread.sleep(2000);
        try {
            financialAdmin.navigateFinancialReviewPage();
        }catch (Throwable e){
            logger.log(Status.FAIL,e.getMessage());
            logger.addScreenCaptureFromPath(takeScreenshotForStep("Financial Review Page"));
        }
        Thread.sleep(5000);
        boolean found  = false;
        try {
            found =  financialAdmin.approvingFinancialAppointment(1,"Pending");
        } catch (Throwable e) {
            logger.log(Status.FAIL,e.getMessage());
            logger.addScreenCaptureFromPath(takeScreenshotForStep("Pending Appointment to be clicked"));
        }
        try {
            if(found) {
                financialAdmin.clickApproveButton();
                logger.addScreenCaptureFromPath(takeScreenshotForStep("After Approved the pending appointment"));
            }
        }catch (Throwable e){
            logger.log(Status.FAIL,e.getMessage());
            logger.addScreenCaptureFromPath(takeScreenshotForStep("After Approved the pending appointment"));
        }
        lo.click_logOut();


    }


    @Test(description = "This TC will perform valid login and navigated to finance archive page and approve multiple pending status")
    public void approveFinancialArchiveMultiplePendingAppointment() throws Throwable {

        driver.get("http://qa.ims.client.sstech.us/login");
        LoginPage lo = new LoginPage(driver);
        FinancialAdminPage FA=new FinancialAdminPage(driver);

        logger = extent.createTest(BaseClass.getMethodName() + "method started");

        lo.doLogin(datasheet.get("UserName"),datasheet.get("Password"));
        logger.addScreenCaptureFromPath(takeScreenshotForStep("Home Page"));
        logger.log(Status.PASS, "Login Clicked");
        Thread.sleep(2000);

        boolean isSelected =  FA.navigateFinancialArchivePage();
        if(!isSelected)
        {
            WebElement el = FA.getArchivetab();
            String timeStamp = new SimpleDateFormat("dd-MM-YYYY_HH-mm-ss").format(new Date());
            logger.addScreenCaptureFromPath(takeScreenshotForStep("taking screenshot"+timeStamp+".png",el));
            Assert.assertTrue(false,"Tab not highlighted");

        }

        Thread.sleep(5000);
        boolean found  =false;
        try {
            found  =   FA.approvingFinancialAppointment(2,"Pending");
        } catch (Throwable e) {
            logger.log(Status.FAIL,e.getMessage());
            logger.addScreenCaptureFromPath(takeScreenshotForStep("Pending Appointment to be clicked"));
        }
        try {
            if(found)
                FA.clickApproveButton();

        }catch (Throwable e){
            logger.log(Status.FAIL,e.getMessage());
            logger.addScreenCaptureFromPath(takeScreenshotForStep("After Approved the pending appointment"));
        }
        lo.click_logOut();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.log(Status.FAIL, "Test Case Failed due to " + result.getThrowable());


        }
        String methodName = BaseClass.getMethodName();
        logger.addScreenCaptureFromPath(takeScreenshotForStep("End of " + methodName));

    }


}
