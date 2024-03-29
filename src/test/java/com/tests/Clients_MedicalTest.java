package com.tests;

import java.io.IOException;

import com.aventstack.extentreports.Status;
import com.pom.DashBoardPage;
import com.pom.LoginPage;
import com.pom.RequestAppointmentPage;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.base.BaseClass;

@Listeners({com.listeners.ListenerTest.class})
public class Clients_MedicalTest extends BaseClass {


	@Test()
	public void requestClientsMedicalAppointment() throws InterruptedException, IOException {

		driver.get("http://qa.ims.client.sstech.us/login");
		LoginPage lo = new LoginPage(driver);
		logger = extent.createTest(BaseClass.getMethodName() + "method started");

		lo.doLogin(datasheet.get("UserName"),datasheet.get("Password"));

		logger.addScreenCaptureFromPath(takeScreenshotForStep("medical"));
		logger.log(Status.PASS, "Login Clicked");
		RequestAppointmentPage vi = new RequestAppointmentPage(driver);
		logger.addScreenCaptureFromPath(takeScreenshotForStep("medical"));
		vi.createAppointmentFromClient("Medical");

		logger.addScreenCaptureFromPath(takeScreenshotForStep("new Appointment booked"));
		logger.log(Status.PASS, "Appointment Created");
		lo.click_logOut();

	}
	@Test(description = "This TC will perform valid login and verified that all NonMedical appoinmets will create and serach")
	public void requestClientsNonMedicalAppointment() throws InterruptedException, IOException {


		logger = extent.createTest(BaseClass.getMethodName() + "method started");
		driver.get("http://qa.ims.client.sstech.us/login");
		LoginPage lo = new LoginPage(driver);
		lo.doLogin(datasheet.get("UserName"),datasheet.get("Password"));

		DashBoardPage db = new DashBoardPage(driver);

		logger.log(Status.PASS, "Login Clicked");

		RequestAppointmentPage vi = new RequestAppointmentPage(driver);
		logger.addScreenCaptureFromPath(takeScreenshotForStep("Nonmedical"));
		vi.createAppointmentFromClient("nonmedical");
		logger.log(Status.PASS, "Appointment Created");
		lo.click_logOut();

	}

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL, "Test Case Failed due to " + result.getThrowable());

		}
		String methodName = BaseClass.getMethodName();
		logger.log(Status.PASS, "Method completed");
		logger.addScreenCaptureFromPath(takeScreenshotForStep("End of " + methodName));


	}


}