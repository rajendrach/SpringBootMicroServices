package org.java.test;

import org.java.controller.Application;
import org.java.controller.rest.Product;
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
@IntegrationTest("server.port=8081")
public class ProductControllerIntegerationTest {

private RestTemplate rT = new TestRestTemplate();
	
	@Test
	public void product(){
		ResponseEntity<Product> entity = rT.getForEntity("http://localhost:8081/product?id=2", Product.class);
		Assert.assertTrue(entity.getStatusCode().is2xxSuccessful());
		Assert.assertEquals("abcd2", entity.getBody().getSku());
		Assert.assertEquals("Product2", entity.getBody().getDescription());
	}
}
