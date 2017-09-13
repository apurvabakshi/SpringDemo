package com.demo.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import com.demo.spring.UserAccount;


@Aspect
public class LoggingAspect {	
	
	@Before("execution(* com.demo.spring.BankOperations.Withdraw(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("**inside Before...");
		Object user = joinPoint.getArgs()[0];
		if (user instanceof UserAccount) {
		       System.out.println("Balance Before transaction:"+((UserAccount) user).getAcc().get(123));
		    } 
		
	}
	
	 @Around("execution(* com.demo.spring.BankOperations.Withdraw(..))")
	    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable
	    {
		 System.out.println("**inside Around...");
	        try {
	        	Object user = joinPoint.getArgs()[0];
	        	String amt=(String)joinPoint.getArgs()[1];
	        	int bal=((UserAccount) user).getAcc().get(123);
	    		if (user instanceof UserAccount) {
	    		    if(bal<Integer.parseInt(amt)){  
	    		    	System.out.println("Insufficient Balance!!Current balance:"+bal);
	    		    }
	    		    else{
	    		    	 joinPoint.proceed();
	    		    }
	    		  } 
	        } finally {
	        }
	    }
	 
	    @AfterReturning(pointcut="execution(* com.demo.spring.BankOperations.Deposit(..))", returning="user")
	    public void logAfterReturning(Object user) throws Throwable
	    {
	        System.out.println("**inside AfterReturning...");
	        System.out.println("Balance after Deposit:"+((UserAccount)user).getAcc().get(123));
	    }
	    
	    @After("execution(* com.demo.spring.BankOperations.Withdraw(..))")
	    public void printReceiptForWithdraw(JoinPoint joinPoint){
	    	printRecepit(joinPoint);
	    }
	    
	    @After("execution(* com.demo.spring.BankOperations.Deposit(..))")
	    public void printReceiptForDeposit(JoinPoint joinPoint){
	    	printRecepit(joinPoint);
	    	}
	    
	    @After("execution(* com.demo.spring.BankOperations.Transfer(..))")
	    public void printReceiptForTransfer(JoinPoint joinPoint){
	    	printRecepit(joinPoint);
	    	}
	    
	    private void printRecepit(JoinPoint joinPoint){
	    	Object user = joinPoint.getArgs()[0];
	    	if (user instanceof UserAccount) {
	    	System.out.println("***Repeipt***");
	    	System.out.println("Acc no 123:"+((UserAccount) user).getAcc().get(123));
	    	System.out.println("Acc no 456:"+((UserAccount) user).getAcc().get(456));
	    	}
	    }

}
