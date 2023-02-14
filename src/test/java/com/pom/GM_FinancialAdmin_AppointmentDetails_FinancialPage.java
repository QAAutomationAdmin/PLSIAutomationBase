package com.pom;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class GM_FinancialAdmin_AppointmentDetails_FinancialPage extends BaseClass {
   public  WebDriver wd;
    public GM_FinancialAdmin_AppointmentDetails_FinancialPage(WebDriver driver){
        wd=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (xpath = "//tbody[@class='MuiTableBody-root css-1xnox0e']//tr[1]//td[3]")
    private WebElement headerView;
    @FindBy (xpath = "//button[text()='Financial']")
    private WebElement financialTab;

    @FindBy (xpath = "//div[@id='grid_viewFinancialdetails_editfields']")
    private WebElement editFieldsExpectedBtn;

    @FindBy (xpath = "//button[@id='btn_viewEditActualInterpreterPayout_editfields']")
    private WebElement editFieldsActualBtn;

    @FindBy (xpath = "//input[@name='CheckInTime']")
    private WebElement requestedStartTime;

    @FindBy (xpath = "//input[@name='CheckOutTime']")
    private WebElement requestedEndTime;

    @FindBy (xpath = "//input[@name='ActualDuration']")
    private WebElement checkINDuration;

    @FindBy (xpath = "(//label[@id='typo_actualInterpreterPayOut_hourspaymenttype']/../following-sibling::div//input)[1]")
    private WebElement hoursPaymentType;

    @FindBy (xpath = "//input[@name='BusinessHourDuration']")
    private WebElement interpreterDurationBusinessHours;

    @FindBy (xpath = "//input[@name='AfterHourDuration']")
    private WebElement interpreterDurationAfterHours;

    @FindBy (xpath = "//input[@name='PayOut']")
    private WebElement expectedInterpreterPayout;

    @FindBy (xpath = "//input[@name='MilesTraveled']")
    private WebElement interpreterMilesTraveled;

    @FindBy (xpath = "//input[@name='MilesTravelReimbursement']")
    private WebElement interpreterTravelReimbursementMiles;

    @FindBy (xpath = "//input[@name='TotalHoursTravel']")
    private WebElement interpreterTotalTravelTimeHours;

    @FindBy (xpath = "//input[@name='TotalMinsTravel']")
    private WebElement interpreterTotalTravelTimeMinutes;

    @FindBy (xpath = "//input[@name='TimeTravelReimbursement']")
    private WebElement interpreterTravelReimbursementTime;

    @FindBy (xpath = "//input[@name='TollandParkingReimbursement']")
    private WebElement interpreterRequestedTollsParkingReimbursement;

    @FindBy (xpath = "//input[@name='InterpreterFlatRate']")
    private WebElement interpreterFlatRate;

    @FindBy (xpath = "//input[@name='TotalPay']")
    private WebElement totalExpectedInterpreterPay;

    @FindBy (xpath = "//input[@id='react-select-5-input']")
    private WebElement clientBDHoursPaymentType;

    @FindBy (xpath = "//input[@name='ClientBusinessHours']")
    private WebElement expectedClientBillingBusinessHours;

    @FindBy (xpath = "//input[@name='ClientAfterHours']")
    private WebElement expectedClientBillingAfterHours;

    @FindBy (xpath = "//input[@name='ClientBusinessHours']")
    private WebElement expectedClientBillingRateBusinessHours;

    @FindBy (xpath = "//input[@name='ClientAfterHours']")
    private WebElement expectedClientBillingRateAfterHours;

    @FindBy (xpath = "//input[@name='ClientCharge']")
    private WebElement expectedClientCharge;

    @FindBy (xpath = "//input[@name='ClientMilesTravelReimbursement']")
    private WebElement clientTravelReimbursementMiles;

    @FindBy (xpath = "//input[@name='ClientTimeTravelReimbursement']")
    private WebElement clientTravelReimbursementTime;

    @FindBy (xpath = "//input[@name='ClientTravelRate']")
    private WebElement clientFlatRate;

    @FindBy (xpath = "//input[@name='ClientTotalBilling']")
    private WebElement totalExpectedClientBilling;

    @FindBy (xpath = "//button[@id='btn_viewFinancialdetails_editfields_save']")
    private WebElement saveExpectedPO;

    @FindBy (xpath = "//button[@id='btn_viewEditActualInterpreterPayout_save']")
    private WebElement saveActualPO;

    public void performOperations(WebElement element,String fieldName) throws InterruptedException{
     Thread.sleep(1000);
     element.click();

     Thread.sleep(1000);
     element.sendKeys(Keys.CONTROL + "a" + Keys.CONTROL);

     Thread.sleep(1000);
     element.sendKeys(Keys.BACK_SPACE);

     Thread.sleep(1000);
     element.sendKeys(datasheet.get(fieldName));
    }

    public void editExpectedPayout() throws InterruptedException, IOException {

     Thread.sleep(1000);
     headerView.click();

        Thread.sleep(2000);
        financialTab.click();

        Thread.sleep(2000);
        editFieldsExpectedBtn.click();

        Thread.sleep(2000);
        //requestedStartTime.sendKeys(datasheet.get(""));
     performOperations(requestedStartTime,"Requested Start Time");

     Thread.sleep(2000);
     //requestedEndTime.sendKeys(datasheet.get(""));
     performOperations(requestedEndTime,"Requested End Time");

     Thread.sleep(2000);
     //checkINDuration.sendKeys(datasheet.get(""));
     performOperations(checkINDuration,"Chek-In Duration");

     Thread.sleep(2000);
    performOperations(hoursPaymentType,"Hours Payment Type");
     Thread.sleep(1000);
     hoursPaymentType.sendKeys(Keys.TAB);

     Thread.sleep(2000);
     //interpreterDurationBusinessHours.sendKeys(datasheet.get(""));
     performOperations(interpreterDurationBusinessHours,"Interpreter Duration (Business Hours)");

     Thread.sleep(2000);
     //interpreterDurationAfterHours.sendKeys(datasheet.get(""));
     performOperations(interpreterDurationAfterHours,"Interpreter Duration (After Hours)");

     Thread.sleep(2000);
     //expectedInterpreterPayout.sendKeys(datasheet.get(""));
     performOperations(expectedInterpreterPayout,"Expected Interpreter Payout");

     Thread.sleep(2000);
     //interpreterMilesTraveled.sendKeys(datasheet.get(""));
     performOperations(interpreterMilesTraveled,"Interpreter - Miles Traveled");

     Thread.sleep(2000);
     //interpreterTravelReimbursementMiles.sendKeys(datasheet.get(""));
     performOperations(interpreterTravelReimbursementMiles,"Interpreter - Travel Reimbursement (Miles)");

     Thread.sleep(2000);
     //interpreterTotalTravelTimeHours.sendKeys(datasheet.get(""));
     performOperations(interpreterTotalTravelTimeHours,"Interpreter - Total Travel Time (Hours)");

     Thread.sleep(2000);
     //interpreterTotalTravelTimeMinutes.sendKeys(datasheet.get(""));
     performOperations(interpreterTotalTravelTimeMinutes,"Interpreter - Total Travel Time (Minutes)");

     Thread.sleep(2000);
     //interpreterTravelReimbursementTime.sendKeys(datasheet.get(""));
     performOperations(interpreterTravelReimbursementTime,"Interpreter - Travel Reimbursement (Time)");

     Thread.sleep(2000);
     //interpreterRequestedTollsParkingReimbursement.sendKeys(datasheet.get(""));
     performOperations(interpreterRequestedTollsParkingReimbursement,"Interpreter - Req Tolls & Parking Reimbursement");

     Thread.sleep(2000);
     //interpreterFlatRate.sendKeys(datasheet.get(""));
     performOperations(interpreterFlatRate,"Interpreter - Flat Rate");

     Thread.sleep(2000);
     //totalExpectedInterpreterPay.sendKeys(datasheet.get(""));
     performOperations(totalExpectedInterpreterPay,"Total Expected Interpreter Pay");
     logger.log(Status.INFO,"Edited Total Expected Interpreter pay");
     logger.addScreenCaptureFromPath(takeScreenshotForStep("Total Expected Interpreter pay"));

     Thread.sleep(2000);
     performOperations(clientBDHoursPaymentType,"CB Hours Payment Type");
     Thread.sleep(1000);
     clientBDHoursPaymentType.sendKeys(Keys.TAB);

     Thread.sleep(2000);
     //expectedClientBillingBusinessHours.sendKeys(datasheet.get(""));
     performOperations(expectedClientBillingBusinessHours,"Expected Client Billing (Business Hours)");

     Thread.sleep(2000);
     //expectedClientBillingAfterHours.sendKeys(datasheet.get(""));
     performOperations(expectedClientBillingAfterHours,"Expected Client Billing (After Hours)");

     Thread.sleep(2000);
     //expectedClientBillingRateBusinessHours.sendKeys(datasheet.get(""));


     Thread.sleep(2000);
     //expectedClientBillingRateAfterHours.sendKeys(datasheet.get(""));
     performOperations(expectedClientBillingRateAfterHours,"Expected Client Billing Rate (After Hours)");

     Thread.sleep(2000);
     //expectedClientCharge.sendKeys(datasheet.get(""));
     performOperations(expectedClientCharge,"Expected Client Charge");

     Thread.sleep(2000);
     //clientTravelReimbursementMiles.sendKeys(datasheet.get(""));
     performOperations(clientTravelReimbursementMiles,"Client Travel Reimbursement (Miles)");

     Thread.sleep(2000);
     //clientTravelReimbursementTime.sendKeys(datasheet.get(""));
     performOperations(clientTravelReimbursementTime,"Client Travel Reimbursement (Time)");

     Thread.sleep(2000);
     //clientFlatRate.sendKeys(datasheet.get(""));
     performOperations(clientFlatRate,"Client - Flat Rate");

     Thread.sleep(2000);
     //totalExpectedClientBilling.sendKeys(datasheet.get(""));
     performOperations(totalExpectedClientBilling,"Total Expected Client Billing");
     logger.log(Status.INFO,"Edited Total Expected Client Billing");
     logger.addScreenCaptureFromPath(takeScreenshotForStep("Total Expected Client Billing"));

     Thread.sleep(2000);
     saveExpectedPO.click();
    }
    public void editActualPayout() throws InterruptedException, IOException {
     Thread.sleep(1000);
     headerView.click();

     Thread.sleep(2000);
     financialTab.click();

     Thread.sleep(2000);
     editFieldsActualBtn.click();

     Thread.sleep(2000);
     //requestedStartTime.sendKeys(datasheet.get(""));
     performOperations(requestedStartTime,"Requested Start Time");

     Thread.sleep(2000);
     //requestedEndTime.sendKeys(datasheet.get(""));
     performOperations(requestedEndTime,"Requested End Time");

     Thread.sleep(2000);
     //checkINDuration.sendKeys(datasheet.get(""));
     performOperations(checkINDuration,"Chek-In Duration");

     Thread.sleep(2000);
     performOperations(hoursPaymentType,"Hours Payment Type");
     Thread.sleep(1000);
     hoursPaymentType.sendKeys(Keys.TAB);

     Thread.sleep(2000);
     //interpreterDurationBusinessHours.sendKeys(datasheet.get(""));
     performOperations(interpreterDurationBusinessHours,"Interpreter Duration (Business Hours)");

     Thread.sleep(2000);
     //interpreterDurationAfterHours.sendKeys(datasheet.get(""));
     performOperations(interpreterDurationAfterHours,"Interpreter Duration (After Hours)");

     Thread.sleep(2000);
     //expectedInterpreterPayout.sendKeys(datasheet.get(""));
     performOperations(expectedInterpreterPayout,"Expected Interpreter Payout");

     Thread.sleep(2000);
     //interpreterMilesTraveled.sendKeys(datasheet.get(""));
     performOperations(interpreterMilesTraveled,"Interpreter - Miles Traveled");

     Thread.sleep(2000);
     //interpreterTravelReimbursementMiles.sendKeys(datasheet.get(""));
     performOperations(interpreterTravelReimbursementMiles,"Interpreter - Travel Reimbursement (Miles)");

     Thread.sleep(2000);
     //interpreterTotalTravelTimeHours.sendKeys(datasheet.get(""));
     performOperations(interpreterTotalTravelTimeHours,"Interpreter - Total Travel Time (Hours)");

     Thread.sleep(2000);
     //interpreterTotalTravelTimeMinutes.sendKeys(datasheet.get(""));
     performOperations(interpreterTotalTravelTimeMinutes,"Interpreter - Total Travel Time (Minutes)");

     Thread.sleep(2000);
     //interpreterTravelReimbursementTime.sendKeys(datasheet.get(""));
     performOperations(interpreterTravelReimbursementTime,"Interpreter - Travel Reimbursement (Time)");

     Thread.sleep(2000);
     //interpreterRequestedTollsParkingReimbursement.sendKeys(datasheet.get(""));
     performOperations(interpreterRequestedTollsParkingReimbursement,"Interpreter - Req Tolls & Parking Reimbursement");

     Thread.sleep(2000);
     //interpreterFlatRate.sendKeys(datasheet.get(""));
     performOperations(interpreterFlatRate,"Interpreter - Flat Rate");

     Thread.sleep(2000);
     //totalExpectedInterpreterPay.sendKeys(datasheet.get(""));
     performOperations(totalExpectedInterpreterPay,"Total Expected Interpreter Pay");
     logger.log(Status.INFO,"Edited Total Expected Interpreter Pay");
     logger.addScreenCaptureFromPath(takeScreenshotForStep("Total Expected Interpreter Pay"));

     Thread.sleep(2000);
     performOperations(clientBDHoursPaymentType,"CB Hours Payment Type");
     Thread.sleep(1000);
     clientBDHoursPaymentType.sendKeys(Keys.TAB);

     Thread.sleep(2000);
     //expectedClientBillingBusinessHours.sendKeys(datasheet.get(""));
     performOperations(expectedClientBillingBusinessHours,"Expected Client Billing (Business Hours)");

     Thread.sleep(2000);
     //expectedClientBillingAfterHours.sendKeys(datasheet.get(""));
     performOperations(expectedClientBillingAfterHours,"Expected Client Billing (After Hours)");

     Thread.sleep(2000);
     //expectedClientBillingRateBusinessHours.sendKeys(datasheet.get(""));


     Thread.sleep(2000);
     //expectedClientBillingRateAfterHours.sendKeys(datasheet.get(""));
     performOperations(expectedClientBillingRateAfterHours,"Expected Client Billing Rate (After Hours)");

     Thread.sleep(2000);
     //expectedClientCharge.sendKeys(datasheet.get(""));
     performOperations(expectedClientCharge,"Expected Client Charge");

     Thread.sleep(2000);
     //clientTravelReimbursementMiles.sendKeys(datasheet.get(""));
     performOperations(clientTravelReimbursementMiles,"Client Travel Reimbursement (Miles)");

     Thread.sleep(2000);
     //clientTravelReimbursementTime.sendKeys(datasheet.get(""));
     performOperations(clientTravelReimbursementTime,"Client Travel Reimbursement (Time)");

     Thread.sleep(2000);
     //clientFlatRate.sendKeys(datasheet.get(""));
     performOperations(clientFlatRate,"Client - Flat Rate");

     Thread.sleep(2000);
     //totalExpectedClientBilling.sendKeys(datasheet.get(""));
     performOperations(totalExpectedClientBilling,"Total Expected Client Billing");
     logger.log(Status.INFO,"Edited Total Expected Client Billing");
     logger.addScreenCaptureFromPath(takeScreenshotForStep("Total Expected Client Billing"));

     Thread.sleep(2000);
     saveActualPO.click();
    }
}