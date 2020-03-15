package AllServices;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import EmployeeAdd.Regular_Employee;

public class FetchTest {
	public List<Regular_Employee> showAllRegularEmployees() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
        SessionFactory factory=meta.getSessionFactoryBuilder().build();  
        Session session=factory.openSession();  
        @SuppressWarnings("unchecked")
		TypedQuery<Regular_Employee> query = session.getNamedQuery("showAll");
		List<Regular_Employee> list = null;
        try{
        	 list = query.getResultList();       
        } catch( Exception e) {
        	e.printStackTrace();
        } finally {
        	System.out.println("Fetched Successfully");
        }
        return list;
	}

}
