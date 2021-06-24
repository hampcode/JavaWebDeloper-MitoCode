package com.hampcode;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hampcode.model.domain.Product;
import com.hampcode.model.repository.ProductRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
//@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class ProductRepositoryIntegrationTest {
	
	@Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private ProductRepository productRepository;

    
    @Test
    public void whenFindByName_thenReturnProduct() {
        // given
        Product product = new Product();
        
        product.setName("Test");
        product.setPrice(12.34);
        entityManager.persist(product);
        entityManager.flush();
     
        // when
        Product productFound = productRepository.findByName(product.getName());
     
        // then
        assertThat(productFound.getName()).isEqualTo(product.getName());
    }
    
    @Test
    public void testSaveProduct() {
  
        Product product = new Product();
        product.setName("Test");
        //product.setPrice(12.34);
        Long id = entityManager.persistAndGetId(product, Long.class);
        assertNotNull(id);
        /*Employee employee2 = employeeRepository.findByFirstName("admin");
        assertNotNull(employee);
        assertEquals(employee2.getFirstName(), employee.getFirstName());
        assertEquals(employee2.getLastName(), employee.getLastName());*/
    } 
    
    @Test
    public void should_store_a_product() {
    	 Product product = new Product();
         product.setName("Bebidas");
         product.setPrice(12.34);
         
         Product productNew = productRepository.save(product);
   
         assertEquals(product, productNew);
         
		//assertThat(productNew).hasFieldOrPropertyWithValue("name", "Test");
        //assertThat(productNew).hasFieldOrPropertyWithValue("price", 12.34);
    }
}
