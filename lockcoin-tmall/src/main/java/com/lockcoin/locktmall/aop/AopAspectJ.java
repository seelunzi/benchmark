package com.lockcoin.locktmall.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

/**
 * @author tangwenbo
 * @date 2018/2/2
 * @since JDK1.8
 */
@Aspect
@Configuration
public class AopAspectJ {

    public static final String EDP = "execution(* com.lockcoin.locktmall.controller..*.*(..))";

    /***
     * 前置通知
     * */
    @Before(EDP)
    public void before(JoinPoint joinPoint) {
        Object target = joinPoint.getTarget();
        System.out.println(target.toString());
    }

    /***
     * 后置通知
     * */
    @After(EDP)
    public void after(JoinPoint joinPoint) {
        System.out.println("后置通知");
    }

    @Around(EDP)
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

        // 调用方法的参数
        Object[] args = pjp.getArgs();
        // 调用的方法名
        String method = pjp.getSignature().getName();
        // 获取目标对象
        Object target = pjp.getTarget();
        // 执行完方法的返回值
        // 调用proceed()方法，就会触发切入点方法执行
        Object result = pjp.proceed();
        return result;
    }

    @AfterThrowing(value = EDP, throwing = "ex")
    public void doAfterThrowing(JoinPoint jp, Exception ex) {
        System.out.println("===========执行异常通知============");
    }
}
