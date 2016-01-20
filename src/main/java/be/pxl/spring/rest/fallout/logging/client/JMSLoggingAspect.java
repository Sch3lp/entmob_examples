package be.pxl.spring.rest.fallout.logging.client;

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

    @Around("@annotation(be.pxl.spring.rest.fallout.logging.client.Loggable)")
    public Object logMessage(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        String action = proceedingJoinPoint.getSignature().toShortString();
        logger.log(user, String.format("performed action:[%s]", action));
        return proceedingJoinPoint.proceed();
    }

}
