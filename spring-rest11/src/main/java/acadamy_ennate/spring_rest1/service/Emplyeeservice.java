package acadamy_ennate.spring_rest1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
	
	
		return (List<Employee>) er.findAll();
	}

	@Override
	public Employee findone(String id) {
	
		Optional<Employee> existing=er.findById(id);
		 if( !existing.isPresent()) {
			 throw new EmployeeNotFoundException("Employee with id"+id+"Not found");
		 }else {
			return existing.get(); 
		 }
	
		
	}

	@Override
	@Transactional
	public Employee create(Employee em) {
		
		Optional<Employee> e=er.findByEmailid(em.getEmailid());
		 System.out.println(e);
		 if( e.isPresent()) {
			 throw new EmployeeNotFoundException("Bad request");
		 }else {
			return er.save(em); 
		 }
	
	}

	@Override
	@Transactional
	public Employee update(String id, Employee em) {
		Optional<Employee> e=er.findById(id);
		 if( !e.isPresent()) {
			 throw new EmployeeNotFoundException("Employee with id"+id+"Not found");
		 }else {
			return er.save(em); 
		 }
	
	}

	@Override
	@Transactional
	public void delete(String id) {
		Optional<Employee> e=er.findById(id);
		 if( !e.isPresent()) {
			 throw new EmployeeNotFoundException("Employee with id"+id+"Not found");
		 }else {
			er.delete(e.get()); 
		 }
	
	}


	

}
