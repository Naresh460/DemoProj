package com.Runer;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = ".\\src\\main\\resources\\registartion.feature",
		glue = "com.stepdefination"	,
		monochrome = true,
		//plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		dryRun=false
		
		)


public class RunerFile {
	
	
}
