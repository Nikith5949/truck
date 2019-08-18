package acadamy_ennate.spring_rest1.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import acadamy_ennate.spring_rest1.entity.Employee;
@Repository
public class EmplyeeRepositoryimp implements Employeerepository{

	

	@PersistenceContext
	private EntityManager em;
	
	
	
	@Override
	public List<Employee> findall() {
	TypedQuery<Employee> q= em.createNamedQuery("Employee.findall",Employee.class);
		List<Employee> result=q.getResultList();
		
		
		return result;
	
	}

	@Override
	public Employee findone(String id) {
		
		return em.find(Employee.class,id);
		
	}
	
	public Employee findbyemail(String email) {
	
		TypedQuery<Employee> q= em.createNamedQuery("Employee.findbyemail",Employee.class);
		q.setParameter("param1",email);
		List<Employee> result=q.getResultList();
		if(result!=null && result.size()==1)
		{return result.get(0);}
		else {
			return null;
		}
		

	}
	
	@Override
	public Employee create(Employee e) {
		
		em.persist(e);
		return(e);
		
	}

	
	@Override
	//@Transactional
	public void delete(Employee e) {
		
	em.remove(e);
	
}

	@Override
	//@Transactional
	public Employee update(Employee e) {
		em.merge(e);
		return e;
	
	
	}





	}
