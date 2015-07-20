package org.java.controller.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Named
@Path("/")
public class CustomerRest {
	private static List<Customer> Customers = new ArrayList<Customer>();

	static {
		Customer customer1 = new Customer();
		customer1.setId(1);
		customer1.setName("Customer 1");
		customer1.setEmail("customer1@gmail.com");

		Customer customer2 = new Customer();
		customer2.setId(2);
		customer2.setName("Customer 2");
		customer2.setEmail("customer2@gmail.com");

		Customer customer3 = new Customer();
		customer3.setId(3);
		customer3.setName("Customer 3");
		customer3.setEmail("customer3@gmail.com");

		Customer customer4 = new Customer();
		customer4.setId(4);
		customer4.setName("Customer 4");
		customer4.setEmail("customer4@gmail.com");

		Customer customer5 = new Customer();
		customer5.setId(5);
		customer5.setName("Customer 5");
		customer5.setEmail("customer5@gmail.com");

		Customers.add(customer1);
		Customers.add(customer2);
		Customers.add(customer3);
		Customers.add(customer4);
		Customers.add(customer5);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> getCustomers() {
		return Customers;
	}

	@GET
	@Path("customer")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer getCustomer(@QueryParam("id") long id){
		Customer cli = null;
		for(Customer c : Customers){
			if(c.getId() == id){
				cli =c;
			}
		}
		return cli;
		
	}
}
