package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

public class RunnerClass {
	

	@RunWith(Cucumber.class)
	@CucumberOptions
					(
						features = "D:\\HSBC_ClientAssignment\\src\\test\\resources\\Assignment.feature",
						glue = {"StepDefination"}
						
					)

	public class RunnerClass1 {

	}

}
