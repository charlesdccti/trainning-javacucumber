package com.charles.Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/alugar_filme.feature",
		glue = "com.charles.steps",
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		monochrome = true,
		tags = "~@ignore",
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false
		)
public class Runner {

}
