package testRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {".//features/"},
							 //{".//features/7rmartLogin.feature",
							//".//features/7rmartHome.feature",
							// ".//features/7rmartAdminUsers.feature"},
							//{".//features/7rmartAdminUsers.feature:36"},//-to run a specifies scenario,specify starting row No.,     
							//{".//features/7rmartCategory.feature"},
							//{".//features/7rmartSubCategory.feature"},
							//{".//features/7rmartManageContact.feature"}
							tags="@sanity", // this will execute scenarios tagged with @sanity
							//tags="@regression"
							//tags="@sanity and @regression" //Scenarios tagged with both @sanity and @regression
							//tags="@sanity and not @regression" //Scenarios tagged with @sanity but not tagged with @regression
							//tags="@sanity or @regression" //Scenarios tagged with either @sanity or @regression
							glue="stepsDefinitions",
							dryRun=false,      // checks mapping between scenario steps and step definition methods
							monochrome=true,  // to avoid junk characters in output
							plugin= {"pretty","html:target/htmlreport.html"}
				)
public class TestRun {
	
}
