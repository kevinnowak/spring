package com.github.kevinnowak.aspect;

import com.github.kevinnowak.model.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("execution(* com.github.kevinnowak.service.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        logger.info("Method " + methodName + " with parameters " + Arrays.asList(arguments) + " will execute");
        Comment comment = new Comment("Other text", "Other author");
        Object[] newArguments = {comment};
        var returnedObject = joinPoint.proceed(newArguments);
        logger.info("Method executed and returned " + returnedObject);

        return "FAILED";
    }
}
