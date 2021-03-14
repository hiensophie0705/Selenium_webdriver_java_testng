package Testng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ReportListener  implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("Làm gì đó sau khi class được chạy xong DONE");
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("Làm gì đó trước khi class được chạy ");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("Làm gì đó sau khi Testcase này fail trong khoảng bnhiu %");

		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("Làm gì đó sau khi testcase này bị fail");

	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("Làm gì đó sau khi testcase bị skip");

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("Làm gì đó trước khi Testcase này được chạy");

		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("Làm gì sau khi testcase này được DONE");

	}

}
