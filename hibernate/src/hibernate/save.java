package hibernate;
import org.hibernate.*;
import org.hibernate.cfg.*;
public class save {
public static void main(String[] args) {
	Configuration cfg=new Configuration();
	cfg.configure("hibernate.cfg.xml");
	SessionFactory factory=cfg.buildSessionFactory();
	Session session=factory.openSession();
	/*product p=new product();
	p.setProductId(101);
	p.setProName("iphone");
	p.setPrice(25000);*/
	Object o=session.load(product.class, new Integer(101));
	product s=(product)o;
	//for loading transaction scope is not necessary...
	System.out.println("Loaded object product nameis"+ s.getProName());
	//To delete
Transaction tx=session.beginTransaction();
session.delete(s);
//session.save(p);
//System.out.println("Object saved sucessfully...!!");
	tx.commit();
	session.close();
	factory.close();
	}
}
