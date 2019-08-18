package acadamy_ennate.spring_rest1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import acadamy_ennate.spring_rest1.entity.Employee;
import acadamy_ennate.spring_rest1.service.Employeeser;
import acadamy_ennate.spring_rest1.service.Emplyeeservice;

//@ Component
//@ResponseBody
@RestController
@RequestMapping(value="/employees")
public class Employeecont {
	
	@Autowired
	private Employeeser es;
	


	@RequestMapping(method=RequestMethod.GET)
	public List<Employee> findAll(){
		
		return es.findall();
		
		
	}

	@RequestMapping(method=RequestMethod.GET,value="{id}")
	public Employee findone(@PathVariable("id") String id) {
		
		
		return es.findone(id);
		
	}

	

	@RequestMapping(method=RequestMethod.POST)
	public Employee create(@RequestBody Employee e) {
		return es.create(e);
	}

	
	@RequestMapping(method=RequestMethod.PUT , value="{id}")
	public Employee update(@PathVariable("id") String id,@RequestBody Employee em) {
		return es.update(id,em);
	}

	@RequestMapping(method=RequestMethod.DELETE , value="{id}")
	public void delete(@PathVariable("id") String id) {
		es.delete(id);
	}
}
