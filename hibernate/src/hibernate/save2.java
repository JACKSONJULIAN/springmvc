package hibernate;
import org.hibernate.*;
import org.hibernate.cfg.*;
public class save2 {
	public static void main(String[] args) {
		try {
	/*Session session1=null;
SessionFactory sf=new Configuration().configure().buildSessionFactory();
session1=sf.openSession();*/
			Configuration cfg=new Configuration();
			cfg.configure("studaddr.cfg.xml");
			SessionFactory factory=cfg.buildSessionFactory();
			Session session1=factory.openSession();
Transaction tx=session1.beginTransaction();
System.out.println("Inserting Record...");
Address address1=new Address("OMR Road","Chennai","TN","600097");
Address address2=new Address("Ring Road","Banglore","Karnataka","560000");
Student student1=new Student("Eswar",address1);
Student student2=new Student("Joe",address2);
session1.save(student1);
session1.save(student2);
tx.commit();
System.out.println("Done writing...");
session1.close();
factory.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}