package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/com/features"} ,
		glue =  {"stepdefinations" , "AppHooks"} ,
	//	tags = "not @Skip" ,   			// used to run/exclude tag specific scenarios
		plugin = {"pretty" ,
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" ,
				"timeline:test-output-thread/"
				
				 }
		
		)
public class TestRunner {

}
