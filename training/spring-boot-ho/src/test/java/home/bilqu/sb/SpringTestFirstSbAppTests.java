package home.bilqu.sb;

import home.bilqu.sb.hello.HelloWorld;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class) tells JUnit to run using Springâ€™s testing support. SpringRunner is the new name for SpringJUnit4ClassRunner, itâ€™s just a bit easier on the eye.
@RunWith(SpringRunner.class)
//@SpringBootTest is saying â€œbootstrap with Spring Bootâ€™s supportâ€� (e.g. load application.properties and give me all the Spring Boot goodness)
@SpringBootTest(classes = HelloWorld.class)
public class SpringTestFirstSbAppTests {

	@Test
	public void testContextLoads() throws Exception {
	}

}
