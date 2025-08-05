package com.mockDemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.stubbing.Answer;

import static org.mockito.Mockito.*;

public class UserServiceTest {
    private UserRepository repository;
    private UserService service ;


    @BeforeEach
    void setUp(){
        repository =mock(UserRepository.class);
        service = new UserService(repository);

    }

    // handling Exception

    @Test
    void testExceptionHandling(){
        // thenThrow for methods with return with type
        when(repository.findById(1)).thenThrow(new RuntimeException("User Not Found"));

        try{
            service.getUser(1);

        }catch(RuntimeException e){
            System.out.println("Caught:"+ e.getMessage());
        }

        // doThrow() for void methods
        doThrow(new IllegalStateException("Delete failed"))
                .when(repository)
                .deleteUser(2);

        try {
            service.removeUser(2);
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
        }

    }

    // ordered Verifications
    @Test
    void testInOrderVerification(){
        when(repository.findById(1)).thenReturn(new User(1,"Vedika"));
        when(repository.findById(2)).thenReturn(new User(2,"Udit"));
    service.getUser(1);
    service.getUser(2);

    InOrder inOrder = inOrder(repository);
    inOrder.verify(repository).findById(1);
    inOrder.verify(repository).findById(2);

    System.out.println("Order verified");

    }


    // Dynamic Stubbing with Answer
    void testDynamicStubbing(){
        when(repository.findById(anyInt())).thenAnswer((Answer<User>) invocation->{
            Integer id = invocation.getArgument(0);
            return new User(id,"User"+id);
        });

        System.out.println(service.getUser(10));
        System.out.println(service.getUser(20));
    }

    // Resetting mocks
    @Test
    void testResetMock(){
        when(repository.findById(1)).thenReturn(new User(1,"Vedika"));
        System.out.println("Before reset: "+service.getUser(1));
        reset(repository);
        System.out.println("After reset: "+service.getUser(1));
    }
















}
