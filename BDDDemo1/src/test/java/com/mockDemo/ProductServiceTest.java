package com.mockDemo;

import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.timeout;

public class ProductServiceTest {
    @Test
    void testBDDMockitoAndTimeout(){

        // Given
        ProductDAO dao = mock(ProductDAO.class);
        ProductService service = new ProductService(dao);
        given(dao.findById(1)).willReturn(new Product(1,"laptop"));


        // when
        Product p = service.getProduct(1);

        //Then
        then(dao).should(timeout(200)).findById(1);
        assert "Laptop".equals(p.getName());



    }
}
