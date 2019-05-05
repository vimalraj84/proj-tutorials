package home.bilqu.sb;

import home.bilqu.sb.hello.HelloWorld;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;

import static org.junit.Assert.assertTrue;

public class FirstSbAppTests {

	@Rule
	public OutputCapture outputCapture = new OutputCapture();

	private String profiles;

	@Before
	public void init() {
		this.profiles = System.getProperty("spring.profiles.active");
	}

	@After
	public void after() {
		if (this.profiles != null) {
			System.setProperty("spring.profiles.active", this.profiles);
		}
		else {
			System.clearProperty("spring.profiles.active");
		}
	}

	@Test
	public void testDefaultSettings() throws Exception {
		HelloWorld.main(new String[0]);
		String output = this.outputCapture.toString();
		assertTrue("Wrong output: " + output, output.contains("Hello Anna"));
	}

	@Test
	public void testCommandLineOverrides() throws Exception {
		HelloWorld.main(new String[] { "--name=Natasha" });
		String output = this.outputCapture.toString();
		assertTrue("Wrong output: " + output, output.contains("Hello Natasha"));
	}

}
