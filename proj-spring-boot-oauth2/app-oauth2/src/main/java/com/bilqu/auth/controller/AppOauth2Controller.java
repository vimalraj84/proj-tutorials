package com.bilqu.auth.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppOauth2Controller {

	@RequestMapping("/user")
	public Principal user(Principal principal) {
		return principal;
	}

}
