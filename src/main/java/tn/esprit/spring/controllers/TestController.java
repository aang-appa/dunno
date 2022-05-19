package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Test;
import tn.esprit.spring.services.ITestService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	ITestService testService;

	@PostMapping("/add-test")
	@ResponseBody
	public Test addTest(@RequestBody Test test) {
		return testService.ajouterTest(test);
	}

}