package home.bilqu.sb.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldService {

	@Value("${name:World}")
	private String name;

	public String getHelloMessage(String name) {
		return String.join(" - " ,"Hello" , name,"Welcome");
	}

}
