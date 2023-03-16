package com.ecommerce.services;

import com.ecommerce.daos.CartDAO;
import com.ecommerce.daos.ProductDAO;
import com.ecommerce.daos.UserDAO;
import com.ecommerce.models.Cart;
import com.ecommerce.models.Product;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CartServiceTest {
    public CartService sut;

    @Mock
    private CartDAO cartDAO;

    @Mock
    private ProductDAO productDAO;

    @Mock
    private UserDAO userDAO;

    @Mock
    private Product mockProduct;

    @Mock
    List<Cart> mockCartList;

    @Mock
    Map<Product, Integer> mockProductMap;

    private int productId = 1;
    private int userId = 1;

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
        sut = new CartService(cartDAO, productDAO, userDAO);
    }

    @Test
    public void findByProductIdTest() {
        Mockito.when(productDAO.findByProductId(productId)).thenReturn(mockProduct);
        Product product = sut.findByProductId(productId);

        Assertions.assertEquals(mockProduct, product);
    }

//    @Test
//    public void getCartTest() {
//        Mockito.when(cartDAO.getCart(userId)).thenReturn(mockCartList);
//        Map<Product, Integer> productMap = sut.getCart(userId);
//
//        Assertions.assertEquals(mockProductMap, productMap);
//    }

    @Test
    public void clearCartTest() {
        sut.clearCart(userId);
        verify(cartDAO).clearCart(userId);
    }
}
