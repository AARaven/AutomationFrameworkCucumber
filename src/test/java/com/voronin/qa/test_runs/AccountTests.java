package com.voronin.qa.test_runs;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith( Cucumber.class )
@CucumberOptions( glue = { "com.voronin.qa" },
                  features = { "src/test/resources/features" },
                  tags = { "@account" },
                  plugin = { "pretty" } )
public class AccountTests {
}


