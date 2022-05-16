package com.yjj.spring_9_2;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.util.LangUtil.ProcessController.Thrown;

public class LogAop {
	
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		
		String signatureStr = joinPoint.getSignature().toShortString();
		// 공통 기능이 적용될 메서드 (joinPoint)의 이름 불러오기
		System.out.println(signatureStr + " 메서드가 시작되었습니다.");
		// joinPoint(메서드)의 이름 출력 
		
		long st = System.currentTimeMillis(); // 현재시간 가져오기
		
		try {
			Object obj = joinPoint.proceed(); // joinpoint 메서드 실행
			return obj;
		} finally {
			long et = System.currentTimeMillis(); // 현재시간 가져오기
			System.out.println(signatureStr + "메서드가 종료되었습니다.");
			System.out.println(signatureStr + "경과시간 : " + (et-st));
			
		}

	}
	
	public void beforeAdvice() {
		System.out.println("beforeAdvice가 실행됨");
		
	}
	
	public void afterReturningAdvice() {
		System.out.println("afterReturningAdvice가 실행됨");
		
	}
	public void afterThrowingAdvice() {
		System.out.println("afterThrowingAdvice가 실행됨");
		
	}
	public void afterAdvice() {
		System.out.println("afterAdvice가 실행됨");
		
	}
	
	
	
	
	
	

}
