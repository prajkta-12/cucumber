package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="Feature_File",glue= {"stepDefination"},tags= ("@user-specific"))


public class LoginRunner {
	

}
