package com.example.it211ss07hw02;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    private String currentUserRole = "VIP"; // Giả lập user chỉ là VIP

    @Before("execution(* com.example.it211ss07hw02.*(..))")
    public void verifyUser(JoinPoint joinPoint) {
        if (!"ADMIN".equals(currentUserRole)) {
            throw new RuntimeException("!! TRUY CẬP BỊ TỪ CHỐI !! User không có quyền gọi "
                    + joinPoint.getSignature().getName());
        }
    }
}