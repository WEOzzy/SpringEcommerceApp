package com.ecommerce.services;

import com.ecommerce.daos.ProductDAO;
import com.ecommerce.models.Product;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    public ProductService sut;

    @Mock
    private ProductDAO productDAO;

    @Mock
    private List<Product> mockList;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Starting AuthService tests...");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Finished AuthService tests.");
    }

    @BeforeEach
    public void beforeEach() {
        sut = new ProductService(productDAO);
    }

    @Test
    public void findAllTest() {
        Mockito.when(productDAO.findAll(Sort.by("title"))).thenReturn(mockList);
        List<Product> productList = sut.findAll();

        Assertions.assertEquals(mockList, productList);
    }

}
