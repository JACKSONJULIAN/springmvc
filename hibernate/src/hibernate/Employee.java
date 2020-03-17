package hibernate;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.TableGenerators;
import org.hibernate.annotations.*;


@Entity
@Table(name="employee30")

public class Employee {

//	private int employeeId;
//	private String fname;
//	private String lname;
//	private int salary;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employeeId")
	private Integer employeeId;
	
	@Column(name="fname")
	private String fname;
	
	@Column(name="lname")
	private String lname;
	
	@Column(name="salary")
	private int salary;
	
	public Employee()
	{}
	

	public Employee(String fname,String lname,int salary)
	{
		this.fname=fname;
		this.lname=lname;
		this.salary=salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}



}
