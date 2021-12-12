package com.greatlearning.crm;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main( String[] args ) {
    	Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass( Customer.class );
	    SessionFactory sessionFactory = con.buildSessionFactory();
        
        CustomerService cs = new CustomerServiceImp( sessionFactory );
//        
       // Customer customer = new Customer();
//        
//        customer.setName( "Rahul" );
//        customer.setDepartment( "Mathematics" );
//        customer.setCountry( "India" );
//        
//        ss.save( student );
//        
       List<Customer> customers  = cs.findAll();
		
		for( Customer customer : customers ) {
		System.out.println( customer );
		}
   }
}	

