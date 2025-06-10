package com.airtech.qa.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.testng.IExecutionListener;

public class TestReportListener implements IExecutionListener {

	 @Override
	    public void onExecutionFinish() {
	        try {
	            File reportFile = new File("test-output/index.html"); // Path of the TestNG report
	            if (reportFile.exists()) {
	                Desktop.getDesktop().browse(reportFile.toURI()); // Opens the file in default browser
	                System.out.println("TestNG Report opened successfully!");
	            } else {
	                System.out.println("Report file not found!");
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 @Override
	 public void onExecutionStart() {
		// TODO Auto-generated method stub
			
	 }
}
