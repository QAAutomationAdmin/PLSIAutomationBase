package com.tests;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import com.pom.LoginPage;
import com.pom.SV_Interpreter_DetailsPage;
import com.pom.VG_Interpreter_ADDInterpreterpage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;

public class    SV_Interpreter_DetailsTest extends BaseClass
{
    WebDriver driver = null;

    XSSFSheet sheet = null;
    @BeforeMethod
    public void Setup() throws IOException {
       // driver = openBrowser();
      //  driver.manage().window().maximize();

    }

    @Test(priority = 1)
    public void create_Interpreter_Availability() throws Throwable {
        driver = openBrowser();
        driver.manage().window().maximize();

        logger = extent.createTest(BaseClass.getMethodName() + "method started");

        LoginPage lo = new LoginPage(driver);
        lo.doLogin(datasheet.get("UserName"), datasheet.get("Password"));

        VG_Interpreter_ADDInterpreterpage mInt = new VG_Interpreter_ADDInterpreterpage(driver);
        mInt.clickInterpreters();
        logger.addScreenCaptureFromPath(takeScreenshotForStep("Create Availability Interpreter table"));

        SV_Interpreter_DetailsPage intAvail = new SV_Interpreter_DetailsPage(driver);
        intAvail.openInterpreterDetailsWindow(datasheet.get("InterpreterName"));
        intAvail.create_Interpreter_Availablity();

    }

    @Test(priority = 2)
    public void update_Interpreter_Availability() throws Throwable
    {
        driver = openBrowser();
        driver.manage().window().maximize();

        logger = extent.createTest(BaseClass.getMethodName() + "method started");

        LoginPage lo = new LoginPage(driver);
        lo.doLogin(datasheet.get("UserName"), datasheet.get("Password"));

        VG_Interpreter_ADDInterpreterpage mInt = new VG_Interpreter_ADDInterpreterpage(driver);
        mInt.clickInterpreters();

        logger.addScreenCaptureFromPath(takeScreenshotForStep("Interpreters table"));

        SV_Interpreter_DetailsPage intAvail = new SV_Interpreter_DetailsPage(driver);
        intAvail.edit_Interpreter_Availablity();
        logger.log(Status.PASS, "Save the updated availability");
        logger.addScreenCaptureFromPath(takeScreenshotForStep("Save the updated availability"));

    }

    @Test(priority = 3)
    public void deleteInt_Avail() throws Throwable {

        driver = openBrowser();
        driver.manage().window().maximize();

        logger = extent.createTest(BaseClass.getMethodName() + "method started");

        LoginPage lo = new LoginPage(driver);
        lo.doLogin(datasheet.get("UserName"), datasheet.get("Password"));

        VG_Interpreter_ADDInterpreterpage mInt = new VG_Interpreter_ADDInterpreterpage(driver);
        mInt.clickInterpreters();

        logger.addScreenCaptureFromPath(takeScreenshotForStep("Interpreters table"));
        logger.log(Status.PASS, "Delete Availability");

        SV_Interpreter_DetailsPage intAvail = new SV_Interpreter_DetailsPage(driver);
        intAvail.openInterpreterDetailsWindow(datasheet.get("InterpreterName"));
        intAvail.delete_Interpreter_Availability();
        logger.log(Status.PASS, " After Delete Availability");
        logger.addScreenCaptureFromPath(takeScreenshotForStep("Delete the updated availability"));
    }

    @Test
    public void create_Proficiency() throws Throwable
    {

        driver = openBrowser();
        driver.manage().window().maximize();

        logger = extent.createTest( BaseClass.getMethodName() + "method started");

        LoginPage lo = new LoginPage(driver);
        lo.doLogin(datasheet.get("UserName"), datasheet.get("Password"));

        VG_Interpreter_ADDInterpreterpage mInt = new VG_Interpreter_ADDInterpreterpage(driver);
        mInt.clickInterpreters();

        logger.addScreenCaptureFromPath(takeScreenshotForStep("Interpreters table"));

        SV_Interpreter_DetailsPage intAvail = new SV_Interpreter_DetailsPage(driver);
        intAvail.openInterpreterDetailsWindow(datasheet.get("InterpreterName"));
        intAvail.add_Proficiency();
        logger.log(Status.PASS, "Add Proficiency");
        logger.addScreenCaptureFromPath(takeScreenshotForStep("Created language proficiency from any interpreter"));

    }

    @Test
    public void remove_LangProficiency() throws Throwable
    {

        driver = openBrowser();
        driver.manage().window().maximize();

        logger = extent.createTest(BaseClass.getMethodName() + "method started");

        LoginPage lo = new LoginPage(driver);
        lo.doLogin(datasheet.get("UserName"), datasheet.get("Password"));

        VG_Interpreter_ADDInterpreterpage mInt = new VG_Interpreter_ADDInterpreterpage(driver);
        mInt.clickInterpreters();

        logger.addScreenCaptureFromPath(takeScreenshotForStep("Interpreters table"));

        SV_Interpreter_DetailsPage intAvail = new SV_Interpreter_DetailsPage(driver);
        intAvail.openInterpreterDetailsWindow(datasheet.get("InterpreterName"));
        intAvail.delete_Proficiency(datasheet.get("Language"));
        logger.log(Status.PASS, "Delete any selected language");
        logger.addScreenCaptureFromPath(takeScreenshotForStep("Delete any selected language proficiency from any interpreter"));

    }


    @AfterMethod
    public void captureResult(ITestResult result) throws IOException {

        String methodName = BaseClass.getMethodName();
        logger.log(Status.PASS, "Method completed");
        logger.addScreenCaptureFromPath(takeScreenshotForStep("End of " + methodName));

        try{
            Thread.sleep(3000);
            driver.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

	@AfterTest
	public void closingTheBrowser(){

		//driver.close();
	}


}
