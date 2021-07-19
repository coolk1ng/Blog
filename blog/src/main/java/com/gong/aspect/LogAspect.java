package com.gong.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by GongXiWu on 2021/05/24
 */

/*日志处理*/
@Aspect
@Component
public class LogAspect {
    //获取日志
    public final Logger logger= LoggerFactory.getLogger(this.getClass());

    //定义切面
    @Pointcut("execution(* com.gong.controller.*.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        HttpServletRequest request = requestAttributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        logger.info("request: {}",requestLog);
    }

    @After("log()")
    public void doAfter(){
        System.out.println("--doAfter--");
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public  void doAfterReturn(Object result){
        logger.info("result :{}",result);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private  class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;

    }
}
