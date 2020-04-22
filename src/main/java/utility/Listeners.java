package utility;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import base.BaseClass;

public class Listeners extends BaseClass implements ITestListener{
	
	
	public void onTestStart(ITestResult result) {
		
		System.out.println("Your Test Case is about to Execute.Test Case Name is: "+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Congrats..your Test case is Passed.Test Case name is: "+result.getName());
		logger=extent.createTest(result.getName());
		logger.log(Status.PASS, "PASS");
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Oops..your Test case is Failed.Test Case name is: "+result.getName());
		logger=extent.createTest(result.getName());
		logger.log(Status.FAIL, "FAIL");
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Warning..your Test case is Skiped.Test Case name is: "+result.getName());
		logger=extent.createTest(result.getName());
		logger.log(Status.SKIP, "SKIPPED");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		System.out.println("Your Test Execution is begining.");
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
		
	}


}
