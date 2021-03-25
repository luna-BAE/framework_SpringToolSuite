package com.bit.sts05.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DeptAop {
	Logger log=LoggerFactory.getLogger(DeptAop.class);

//	@Before("execution(* com.bit.sts05.service.DeptService.select*(..))")
	public void before(JoinPoint jp) {
		log.debug("before...");
		log.debug(jp.getSignature().getName());
		log.debug(Arrays.toString(jp.getArgs()));
	}
	
//	@After("execution(* com.bit.sts05.service.DeptService.select*(..))")
	public void after(JoinPoint jp) {
		log.debug("after...");
	}
	
//	@AfterReturning(
//pointcut = "execution(* com.bit.sts05.service.DeptService.select*(..))"
//,returning = "obj")
	public void afterReturn(JoinPoint jp,Object obj) {
		log.debug("after success...");
		System.out.println(obj);
	}
	
//	@AfterThrowing(
//pointcut = 	"execution(* com.bit.sts05.service.DeptService.select*(..))"
//,throwing = "ex"
//			)
	public void afterErr(JoinPoint jp, Exception ex) {
		log.debug("after fail..");
		System.out.println(ex);
	}
	
//	@Around(value = "execution(* com.bit.sts05.service.DeptService.select*(..))")
	public void around(ProceedingJoinPoint joinPoint){
		log.debug("around before...");
		try {
			joinPoint.proceed();
			log.debug("around afterReturning...");
		} catch (Throwable e) {
			log.debug("around afterThrow...");
		}
		log.debug("around after...");
	}
}