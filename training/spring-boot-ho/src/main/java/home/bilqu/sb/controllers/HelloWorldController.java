package home.bilqu.sb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @RequestMapping("/check")
    @ResponseBody
    public String sayHello(){
       return "Hello Spring Boot HO !";
    }
    
    @RequestMapping(path="/printNumbers",method=RequestMethod.GET)
	@ResponseBody
	public Collection<String> printNumbers(@RequestParam("input") int input) {
		return IntStream.range(0, input).mapToObj(i -> "Printing : " + i).collect(Collectors.toList());
	}

	@GetMapping("/printFibonacci")
	@ResponseBody
	public Collection<String> printFibonacci(@RequestParam("input") int input) {
		return IntStream.range(0, input).mapToObj(i -> "Printing : " + i).collect(Collectors.toList());
	}


}
