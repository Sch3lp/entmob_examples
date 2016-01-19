package be.pxl.spring.rest.fallout.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JMSLoggingAspect {

    @Autowired
    private JMSMessageLogger logger;

    @Around("@annotation(Loggable)")
    public Object logMessage(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        String action = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        logger.log(String.format("User:[%s] performed action:[%s]", user, action));
        return proceedingJoinPoint.proceed();
    }

}
