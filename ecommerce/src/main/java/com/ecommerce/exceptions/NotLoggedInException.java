package com.ecommerce.exceptions;

// Exception thrown by the AuthAspect
// very similar to what was provided in P3, attempting to implement this myself
public class NotLoggedInException extends RuntimeException{
    public NotLoggedInException(String message) {
        super(message);
    }
}
