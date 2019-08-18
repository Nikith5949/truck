package acadamy_ennate.spring_rest1.repository;

import java.util.List;

import acadamy_ennate.spring_rest1.entity.Employee;

public interface Employeerepository {

	
	List<Employee> findall();
	
	Employee findone(String id);
	
	Employee create(Employee e); 
	

	public Employee update(Employee em);
	
	public Employee findbyemail(String email);

	void delete(Employee e);
	
}
