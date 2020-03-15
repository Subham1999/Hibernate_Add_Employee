	package AllServices;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.Metadata;  
import org.hibernate.boot.MetadataSources;  
import org.hibernate.boot.registry.StandardServiceRegistry;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import EmployeeAdd.Contract_Employee;
import EmployeeAdd.Regular_Employee;  
  
public class StoreTest {  
	public void addRegularEmployee(String name, float salary, int bonus) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
          
        SessionFactory factory=meta.getSessionFactoryBuilder().build();  
        Session session=factory.openSession();  
          
        Transaction t=session.beginTransaction();
        
        Regular_Employee e=new Regular_Employee();
        e.setName(name);    
        e.setSalary(salary);    
        e.setBonus(bonus);
        
        session.persist(e);
        
        t.commit();
        session.close();
	}
	public void addContractEmployee(String name, int pph, String duration) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
          
        SessionFactory factory=meta.getSessionFactoryBuilder().build();  
        Session session=factory.openSession();  
          
        Transaction t=session.beginTransaction();
        
        Contract_Employee e=new Contract_Employee();    
        e.setName(name);    
        e.setPay_per_hour(pph);    
        e.setContract_duration(duration); 
        
        session.persist(e);
        
        t.commit();
        session.close();
	} 
}  
