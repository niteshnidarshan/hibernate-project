package com.hbm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hbm.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Jai Ram g Ki!" );
        
        Employee emp = new Employee();
        emp.setEmpId("E101");
        emp.setFirstName("Ram");
        emp.setLastName("G");
        emp.setAge(27);
        
        Configuration conf = new Configuration().configure().addAnnotatedClass(Employee.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory factory = conf.buildSessionFactory(registry);
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(emp);
        tx.commit();
    }
}
