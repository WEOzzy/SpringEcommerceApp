package com.ecommerce.services;

import com.ecommerce.daos.UserDAO;
import com.ecommerce.models.AuthUser;
import com.ecommerce.models.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    public AuthService sut;

    private String email = "mock@email.com";

    @Mock
    private UserDAO userDAO;

    @Mock
    private AuthUser authUser;// =  new AuthUser(email, "password");

    @Mock
    private User mockUser;// = new User(email, "password", "mock", "user");

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
        sut = new AuthService(userDAO);
    }

    @Test
    public void testUserRegistration() {
        Mockito.when(userDAO.save(mockUser)).thenReturn(mockUser);
        User user = sut.register(mockUser);

        Assertions.assertEquals(mockUser, user);
    }

    @Test
    public void testUserLogin() {
        Mockito.when(authUser.getPassword()).thenReturn("password");
        Mockito.when(mockUser.getPassword()).thenReturn("password");
        Mockito.when(userDAO.findByEmail(authUser.getEmail())).thenReturn(Optional.of(mockUser));
        User user = sut.login(authUser);

        Assertions.assertEquals(mockUser, user);
    }
}
