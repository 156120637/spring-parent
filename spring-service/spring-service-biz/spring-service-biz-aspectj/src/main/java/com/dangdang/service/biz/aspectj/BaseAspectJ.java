package com.dangdang.service.biz.aspectj;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Create by tianjiaqin 2019/4/12-22-47
 */
@Slf4j
@Aspect
@Component
public class BaseAspectJ {

    /**
     * 实际开发中不建议使用环绕通知，环绕通知是在切入点执行之前和之后都会触发，注解是  @Around
     *  参数  ProceedingJoinPoint  point。如果处理不好的话可能会出现各种问题，前置，后置，后置返回几乎能够解决我们所有的问题。
     */


    /**
     * 定义切入点表达式
     */
    @Pointcut("execution(* com.dangdang.service.biz.service.impl.AspectJServiceImpl.base(..))")
    public void basePointCut() {
    }

    /**
     * 前置通知 在切入点执行之前执行。
     * @param joinPoint
     */

    @Before(value = "basePointCut()")
    public void doBeforeBaseService(JoinPoint joinPoint) {
        log.info("base aspectJ ,joinpoint is {}" , joinPoint);
    }

    /**
     * 后置通知，在切入点执行完毕之后，没有结果集，因为可能会出现异常
     * @param joinPoint
     */
    @After(value = "basePointCut()")
    public void doAfterBaseService(JoinPoint joinPoint){
        log.info("base aspectJ ,joinpoint is {}" , joinPoint);
    }

    /**
     * 异常通知，只有切入点出现异常的情况下才会执行
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "basePointCut()" , throwing = "ex")
    public void doAfterThrowsBaseService(JoinPoint joinPoint , Exception ex){
        log.info("base aspectJ ,joinpoint is {}" , joinPoint);
    }



    /**
     * 返回通知
     *
     * @param joinPoint 可以从这获取入参等信息。
     * @param results   切的方法返回的参数
     */
    @AfterReturning(value = "basePointCut()", returning = "results")
    public void doAfterReturnBaseService(JoinPoint joinPoint, Object results) {
        log.info("base aspectJ ,joinpoint is {}" , joinPoint);
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof String) {
                // 转换为返回的结果类。做一些操作。
                String str = (String) arg;
            }
        }
    }


}
