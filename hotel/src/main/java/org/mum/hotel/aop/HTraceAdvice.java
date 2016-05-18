package org.mum.hotel.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.mum.hotel.messaging.ApplicationMailer;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class HTraceAdvice {
	@Autowired
	private ApplicationMailer mailService;
	
	@After("execution(* org.mum.hotel.service.CheckinService.updateCheckOut(..))")
	public void traceAftermethod(JoinPoint joinpoint){
		System.out.println("AOP method executed!");
		String to = "jujulalshrestha@gmail.com";
		String subject = "Test mail";
		String body = "Hello, Test mail!";
		mailService.sendMail(to, subject, body);
	}
}
