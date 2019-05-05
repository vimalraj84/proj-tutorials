package home.bilqu.sb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/fb")
public class FirstSbController {


	@RequestMapping(path="/check")
	@ResponseBody
	public String sayHello(){
		return "Hello Spring Boot HO !";
	}

	@RequestMapping(path="/printNumbers",method=RequestMethod.GET)
	@ResponseBody
	public Collection<String> printNumbers(@RequestParam("input") int input) {
		return IntStream.range(0, input).mapToObj(i -> "Printing : " + i).collect(Collectors.toList());
	}

	@GetMapping(path="/printFibonacci")
	@ResponseBody
	public Collection<String> printFibonacci(@RequestParam("input") int input) {
		return IntStream.range(0, input).mapToObj(i -> "Printing : " + i).collect(Collectors.toList());
	}


}
