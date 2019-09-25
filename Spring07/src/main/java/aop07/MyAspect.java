package aop07;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//** @ 방식의 공통적 관심 사항 구현  
// => 매개변수, return 없고 Around 방식

@Component
@Aspect
public class MyAspect {
	@Pointcut("execution(void doSomething())")
	public void myPoint() { }
	
	@Around("myPoint()")
	public void myAround(ProceedingJoinPoint joinpoint) {
		// Before
		System.out.println("** 배 고파요 ~~~ => Before !!!");
		try {
			// 핵심사항	
			joinpoint.proceed() ;
			// 정상종료	
			System.out.println("** 맛있게 먹기 => 핵심적 관심사항 정상종료 !!!");
		}catch (Throwable e) {
			// 핵심사항 비정상종료
			System.out.println("** 엄마한테 혼나요 ~~ => 예외 발생으로 핵심적 관심사항 비정상종료 !!!");
		}finally {
			// After
			System.out.println("** finally: 설겆이 하기 ~~ => 아무튼 최종 종료 !!");
		}
	} // myAround
} // class
