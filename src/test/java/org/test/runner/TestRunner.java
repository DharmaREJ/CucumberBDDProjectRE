package org.test.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources"}, glue = {"org.test.adactin.booking"} , dryRun=false, 
monochrome=true,
plugin= {"pretty","html:target/cucumber-reports/reports_html.html"}, 
tags="@Sanity")
public class TestRunner 
{

}
