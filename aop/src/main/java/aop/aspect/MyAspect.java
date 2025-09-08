package aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
	
	@Before("execution(public aop.domain.Product aop.service.ProductService.find(String))	")
	public void adviceBefore() {
		System.out.println("-- Before Advice --");
	}
	
	@After("execution(aop.domain.Product aop.service.ProductService.find(String))	")
	public void adviceAfter() {
		System.out.println("-- After Advice --");
	}
	
	@AfterReturning("execution(* aop.service.ProductService.find(String))	")
	public void adviceAfterReturning() {
		System.out.println("-- AfterReturning Advice --");
	}
	
	@AfterThrowing(value = "execution(* *..*.ProductService.find(..))",throwing = "ex")			// * = aop.domain.Product 
	public void adviceAfterThrowing(Throwable ex) {												// *..* = aop.service
		System.out.println("-- AfterThrowing[" + ex.getMessage() + "] Advice --");				// .. = String
	}																							// 글자 수 줄이기
	
	@Around("execution(* *..*.*.*(..))")
	public Object adviceAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("-- Around Advice : Before --");
		
		Object result = pjp.proceed();

//		메소드의 파라미터 추가 처리가 있는 경우
//		Object[] params = {"pc"};
//		Object result = pjp.proceed(params);
		
		System.out.println("-- Around Advice : After --");
		
		return result;
	}
	
}