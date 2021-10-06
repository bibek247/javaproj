package com.demo.webservice.demowebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hellorestcontroller {

	
	//@RequestMapping(method=RequestMethod.GET,path="/hello")
	@GetMapping("/hellodemo")
	private String hellomethod() {
		// TODO Auto-generated method stub
				return "Hello from demo service";
	}
	
	// return hello using bean
	//http://localhost:8080/demowebservice-0.0.1-SNAPSHOT/hellobean
	@GetMapping(path="/hellobean")
	public hellobean  hellousingbean() {
		// TODO Auto-generated method stub
		return new hellobean("Hello bean");
	}
	
	// return hello using bean
	//http://localhost:8080/demowebservice-0.0.1-SNAPSHOT/hellobean/bibek
	//@GetMapping(path="/hellobean/path-variable/{name}")
	@GetMapping(path="/hellobean/name/{name}")
	public hellobean  hellousingbeanpathvariable(@PathVariable String name) {
		// TODO Auto-generated method stub
		return new hellobean(String.format("Hello bean,%s",name));
	}

}
