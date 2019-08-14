package acadamy_ennate.spring_rest1.service;

import java.util.List;

import acadamy_ennate.spring_rest1.entity.Employee;

public interface Employeeser {
	
	List<Employee> findall();
	
	Employee findone(String id);
	
	Employee create(Employee em);
	
	Employee update(String id,Employee em);
	void delete(String id);

}
