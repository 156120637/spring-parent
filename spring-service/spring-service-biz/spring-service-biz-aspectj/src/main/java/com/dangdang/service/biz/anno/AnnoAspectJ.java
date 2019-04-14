package com.dangdang.service.biz.anno;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Create by tianjiaqin 2019-04-14
 */
@Slf4j
@Aspect
@Component
public class AnnoAspectJ {

    /**
     * 通过自定义注解的方式来切入某个方法或者类。
     *      这种方法需要在方法上打上注解，相对于使用切入点表达式指定到某一个类或者方法来说都各有优势。
     *
     */


    /**
     * 定义切入点表达式
     *      通过注解的方式直接定义切入点为注解，这样所有打这个注解的方法都会被拦截。
     */
    @Pointcut("@annotation(annoInterfaceAspectJ)")
    public void annoPointCut(AnnoInterfaceAspectJ annoInterfaceAspectJ) {
    }

    /**
     * 前置通知 在切入点执行之前执行。
     * @param joinPoint
     */

    @Before(value = "annoPointCut(annoInterfaceAspectJ)")
    public void doBeforeBaseService(JoinPoint joinPoint , AnnoInterfaceAspectJ annoInterfaceAspectJ) {
        log.info("anno Joinpoint is {}" , joinPoint);
    }

    /**
     * 后置通知，在切入点执行完毕之后，没有结果集，因为可能会出现异常
     * @param joinPoint
     */
    @After(value = "annoPointCut(annoInterfaceAspectJ)")
    public void doAfterBaseService(JoinPoint joinPoint, AnnoInterfaceAspectJ annoInterfaceAspectJ){
        log.info("anno Joinpoint is {}" , joinPoint);

    }

    /**
     * 异常通知，只有切入点出现异常的情况下才会执行
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "annoPointCut(annoInterfaceAspectJ)" , throwing = "ex")
    public void doAfterThrowsBaseService(JoinPoint joinPoint , Exception ex, AnnoInterfaceAspectJ annoInterfaceAspectJ){
        log.info("anno Joinpoint is {}" , joinPoint);

    }



    /**
     * 返回通知
     *
     * @param joinPoint 可以从这获取入参等信息。
     * @param results   切的方法返回的参数
     */
    @AfterReturning(value = "annoPointCut(annoInterfaceAspectJ)", returning = "results")
    public void doAfterReturnBaseService(JoinPoint joinPoint, Object results, AnnoInterfaceAspectJ annoInterfaceAspectJ) {
        log.info("anno Joinpoint is {}" , joinPoint);
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof String) {
                // 转换为返回的结果类。做一些操作。
                String str = (String) arg;
            }
        }
    }



}
