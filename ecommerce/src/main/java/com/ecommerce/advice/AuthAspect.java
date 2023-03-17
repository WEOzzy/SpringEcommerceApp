package com.ecommerce.advice;

import com.ecommerce.annotations.Authorized;
import com.ecommerce.exceptions.NotLoggedInException;
import com.ecommerce.models.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthAspect {

    private final HttpServletRequest req;

    public AuthAspect(HttpServletRequest req) {
        this.req = req;
    }

    @Around("@annotation(authorized)")
    public Object authenticate(ProceedingJoinPoint pjp, Authorized authorized) throws Throwable {
        HttpSession session = req.getSession(); // get the session or create one
        User user = (User) session.getAttribute("user");

        // If the user is not logged in
        if (user == null) {
            throw new NotLoggedInException("Must be logged in to perform this action");
        }

        return pjp.proceed(pjp.getArgs()); // Calls the originally intended method
    }
}
