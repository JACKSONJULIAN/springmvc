package hibernate;
import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class ManageEmployee {
	private static SessionFactory factory;
	public static void main(String[] args) {
	try {
		System.out.println("hello");
		factory=new Configuration().configure().buildSessionFactory();
		/*Configuration cfg=new Configuration();
		cfg.configure("employee1.cfg.xml");
		factory=cfg.buildSessionFactory();
		Session session=factory.openSession();*/
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
		}
	

		
	ManageEmployee ME=new ManageEmployee();
	/* Add few records in database*/
	Integer empID1=ME.addEmployee("Zara","Ali",2000);
	Integer empID2=ME.addEmployee("Daisy","Das",5000);
	Integer empID3=ME.addEmployee("John","Paul",5000);
	Integer empID4=ME.addEmployee("Mohd","Yasee",3000);
	
	// list down all employees
	ME.listEmployees();
	
	//Print total employees count
	ME.countEmployee();
	
	// print total salary
	ME.totalSalary();
	}
	
	// method to create an employee in the database
	
	public Integer addEmployee(String fname, String lname, int salary) {
	Session session=factory.openSession();
	Transaction tx=null;
	Integer employeeID=null;
	
	try {
		tx=session.beginTransaction();
		Employee employee=new Employee(fname,lname,salary);
				 employeeID=(Integer)session.save(employee);
				tx.commit();
		}
	catch(HibernateException e) {
		if(tx!=null)tx.rollback();
		e.printStackTrace();
	}
	finally{
		session.close();
	}
	return employeeID;
}
	
	public void listEmployees() {
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Criteria cr=session.createCriteria(Employee.class);
			cr.add(Restrictions.sizeGt("salary",2000));
			List employees=cr.list();
			for(Iterator itr=employees.iterator();itr.hasNext();)
			{
				Employee employee=(Employee)itr.next();
				System.out.println("First Name:"+employee.getFname());
				System.out.println("Last Name:"+employee.getLname());
				System.out.println("Salary:"+employee.getSalary());
			}
			tx.commit();
		}
			catch(HibernateException e) {
				if(tx!=null)tx.rollback();
				e.printStackTrace();
			}
		finally {
			session.close();
		}
	}
		public void countEmployee() {
			Session session=factory.openSession();
			Transaction tx=null;
				try {
					tx=session.beginTransaction();
					Criteria cr=session.createCriteria(Employee.class);
					cr.setProjection(Projections.rowCount());
					List rowCount=cr.list();
					System.out.println("total count:"+rowCount.get(0));
					tx.commit();
				}
				catch(HibernateException e) {
					if(tx!=null)tx.rollback();
					e.printStackTrace();
				}
			finally {
				session.close();
			}
		}
		public void totalSalary() {
			Session session=factory.openSession();
			Transaction tx=null;
				try {
					tx=session.beginTransaction();
					Criteria cr=session.createCriteria(Employee.class);
					
					//to get salary
					cr.setProjection(Projections.sum("salary"));
					List totalSalary=cr.list();
					
					System.out.println("Total salary:"+totalSalary.get(0));
					tx.commit();
				}
				catch(HibernateException e) {
					if(tx!=null)tx.rollback();
					e.printStackTrace();
				}
				finally {
					session.close();
				}
		}
	}
