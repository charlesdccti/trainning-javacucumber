package com.charles.Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(
		//features = "src/test/resources/features/Test_cucumber.feature",
		features = "src/test/resources/test_cucumber.feature",
		glue = {"com.charles.steps"},
		//	tags = {"@unitários", "not @ignore"},
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)
public class Runner {

}
