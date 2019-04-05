package com.training.utility;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtntRpt {

	public ExtentReports rep;
	public ExtentTest tst;
	
	public void getExtntRpt(String path, String repName, String logStat, String stepName,String stepDetails){
		rep= new ExtentReports(path);
		tst=rep.startTest(repName);
		String stat=logStat;
		switch(stat){
		case "Error":
			tst.log(LogStatus.ERROR, stepName, stepDetails);
			break;
		case "Fail":
			tst.log(LogStatus.FAIL, stepName, stepDetails);
			break;	
		case "Fatal":
			tst.log(LogStatus.FATAL, stepName, stepDetails);
			break;
		case "Info":
			tst.log(LogStatus.INFO, stepName, stepDetails);
			break;
		case "Pass":
			tst.log(LogStatus.PASS, stepName, stepDetails);
			break;
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
