package com.infosys.demo;

import java.text.DateFormat;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	@AfterReturning("execution(* com.infosys.demo.ReportService.generateReport(..))")	
	public int logAfterAdvice(JoinPoint joinPoint){
		
	    //Log Joinpoint signature details
		
		System.out.println("Joinpoint signature :" + joinPoint.getSignature());

		long time = System.currentTimeMillis();
		
        //Log details such as time stamp of report generated
		System.out.println("Report generated at time:" + DateFormat.getDateTimeInstance().format(time));
        return 1;
	}	
	
	@AfterReturning(pointcut = "execution(* com.infosys.demo.HTMLReportGenerator.generateReport(..))",returning = "result")
	public void logAfterAdviceWithReturning(JoinPoint joinPoint,String result) {
		System.out.println("Joinpoint signature :" + joinPoint.getSignature());
		long time = System.currentTimeMillis();
		System.out.println("Inside aspect :"+result);
		System.out.println("Report generated at time:" + DateFormat.getDateTimeInstance().format(time));
	}
	
}
