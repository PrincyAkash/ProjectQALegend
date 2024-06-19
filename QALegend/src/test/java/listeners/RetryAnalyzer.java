package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer { // IRetryAnalyzer interface
	int count = 0;
	int retrylimit = 3;
	
	
	@Override
	public boolean retry(ITestResult result) { // test case status using ITestResult ie pass or fail
		// TODO Auto-generated method stub
		if(count < retrylimit) 
		{
			count++;
			return true;
		}
		
		return false;
	}
}