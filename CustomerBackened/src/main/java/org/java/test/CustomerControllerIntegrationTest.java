package org.java.test;


import org.java.controller.Application;
import org.java.controller.rest.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port=8080")
public class CustomerControllerIntegrationTest {
	
	private RestTemplate rT = new TestRestTemplate();
	
	@Test
	public void customer(){
		ResponseEntity<Customer> entity = rT.getForEntity("http://localhost:8080/customer?id=2", Customer.class);
		Assert.assertTrue(entity.getStatusCode().is2xxSuccessful());
		Assert.assertEquals("customer2@gmail.com", entity.getBody().getEmail());
		Assert.assertEquals("Customer 2", entity.getBody().getName());
	}
}
