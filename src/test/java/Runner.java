
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = "pretty",
		tags = {"@tag1"},
		monochrome = true, 
		snippets = SnippetType.CAMELCASE, 
		dryRun = false //se true não executa as funções
		)
public class Runner {

}
