package acadamy_ennate.spring_rest1.service;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import acadamy_ennate.spring_rest1.Exception.EmployeeNotFoundException;
import acadamy_ennate.spring_rest1.entity.Employee;
import acadamy_ennate.spring_rest1.repository.Employeerepository;
@Service
public class Emplyeeservice implements Employeeser{
	@Autowired
	Employeerepository er;

	
	
	



	@Override
	public List<Employee> findall() {
	
	
		return er.findall();
	}

	@Override
	public Employee findone(String id) {
	
		 Employee e=er.findone(id);
		 if( e==null) {
			 throw new EmployeeNotFoundException("Employee with id"+id+"Not found");
		 }else {
			return e; 
		 }
	
		
	}

	@Override
	@Transactional
	public Employee create(Employee em) {
		
		 Employee e=er.findbyemail(em.getEmailid());
		 System.out.println(e);
		 if( e!=null) {
			 throw new EmployeeNotFoundException("Bad request");
		 }else {
			return er.create(em); 
		 }
	
	}

	@Override
	@Transactional
	public Employee update(String id, Employee em) {
		Employee e=er.findone(id);
		 if( e==null) {
			 throw new EmployeeNotFoundException("Employee with id"+id+"Not found");
		 }else {
			return er.update(em); 
		 }
	
	}

	@Override
	@Transactional
	public void delete(String id) {
		Employee e=er.findone(id);
		 if( e==null) {
			 throw new EmployeeNotFoundException("Employee with id"+id+"Not found");
		 }else {
			er.delete(e); 
		 }
	
	}

	

}
