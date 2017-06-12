package com.xebia.SpringBootApp;

import javax.annotation.processing.SupportedAnnotationTypes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
@EnableAutoConfiguration
@ComponentScan
public class SampleController {
	
	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
       
    Employee employee = new Employee();
    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Employee getEmployeeInJSON(@PathVariable String name) {
       employee.setName(name);
       employee.setEmail("employee1@genuitec.com");
    return employee; 
    }
    @RequestMapping(value = "/{name}.xml", method = RequestMethod.GET, produces = "application/xml")
    public @ResponseBody Employee getEmployeeInXML(@PathVariable String name) {
       employee.setName(name);
     employee.setEmail("employee1@genuitec.com");
       return employee; 
    }


}
