package com.bilqu.zoo.wage.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bilqu.zoo.wage.bo.EmpPayroll;

//This will be the Feign Proxy to call wage service  from ms-wage-service project

@FeignClient(name = "zoo-wage-service")//Reference to the service name in ms-wage-service project
public interface WageServiceProxy {
	
	// Path of the ms-wage-service we want to consume
	@GetMapping("/getWage/roll/{roll}")
	public EmpPayroll getWageByRoll(@PathVariable("roll") String roll);
}
