package acadamy_ennate.spring_rest1.entity;



import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@Entity
@NamedQueries({
	@NamedQuery(name="Employee.findbyemail",query="SELECT emp from Employee emp where emp.emailid=:param1"),
	@NamedQuery(name="Employee.findall",query="SELECT emp from Employee emp")

	
})
public class Employee {
	@Id
	@Column(columnDefinition="Varchar(36)")
	private String id;
	
	private String fname;
	private String lname;
	
	@Column(unique=true)
	private String emailid;
	public Employee() {
	
		this.id = UUID.randomUUID().toString();
	
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", fname=" + fname + ", lname=" + lname + ", emailid=" + emailid + "]";
	}


}
