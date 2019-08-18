package acadamy_ennate.spring_rest1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import acadamy_ennate.spring_rest1.entity.Employee;

public interface Employeerepository extends CrudRepository<Employee,String> {

	
	Optional<Employee> findByEmailid(String emailid);
	
}
