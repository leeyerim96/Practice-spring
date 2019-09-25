package aop08;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//** @ 방식의 공통적 관심 사항 구현
// => 핵심관심사항에 인자(매개변수) 와  return값이 있고
//    개별 메서드 (advice 별 처리) 방식
@Component
@Aspect
public class MyAspect {
	
	@Pointcut("execution(* doSomething(*))")
	public void myPoint() { }
	
	@Before("myPoint()")
	public void myBefofre(JoinPoint joinpoint) {
		System.out.println("** 배 고파요 ~~~ => Before !!!");
		// 1) 인자 Test
		// => 핵심관심사항의 인자(매개변수)  출력 하기
		Object[] args = joinpoint.getArgs();
		for (Object o : args) {
			System.out.println("Before , 핵심사항의 매개변수 => " + o);
		}
	}

	// Test 1. 전달된 Return 값  사용가능함 
	// Test 2. class 의 main 실행시에는 전달된 return 값 출력 됨 확인
	@AfterReturning(pointcut="myPoint()", returning="result")
	public void myAfter_returning(Object result) {
		System.out.println("** myAfter_returning result Test =>"+result);
		result="Result Change";
		System.out.println("** myAfter_returning result change Test =>"+result);
		System.out.println("** 맛있게 먹기 => 핵심적 관심사항 정상종료 !!!");
	}
	
	@AfterThrowing(pointcut="myPoint()", throwing="e")
	public void myAfter_throwing(Exception e) {
		System.out.println("** 엄마한테 혼나요 ~~ => 예외 발생으로 핵심적 관심사항 비정상종료 !!!");
		System.out.println("** myAfter_throwing Exception => "+e.toString());
	}

	// 핵심적 관심사항 수행이후 _after
	// => 정상 종료이건, 비정상 종료이건 무조건시행
	@After("myPoint()")
	public void myAfter() {
		System.out.println("** finally: 설겆이 하기 ~~ => 아무튼 최종 종료 !!");
	}
} // class
