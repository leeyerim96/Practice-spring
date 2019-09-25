package aop09;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//**  @ 방식의 공통적 관심 사항 구현
//=> 핵심관심사항에 인자(매개변수) 와  return값이 있는 경우 
//=> Around  

@Component
@Aspect
public class MyAspect {
	@Pointcut("execution(* do*(*))")
	public void myPoint() { }
	
	@Around("myPoint()")
	public Object myAround(ProceedingJoinPoint joinpoint) {
		// Before
		System.out.println("** 배 고파요 ~~~ => Before !!!");
		//1) 인자 Test
		Object [] args=joinpoint.getArgs();
		for (Object o:args) {
			System.out.println("Before , 핵심사항의 매개변수 => "+o);
		}
		//2) 핵심적 관심사항의 return 값 Test
		// 2.1) result 정의
		Object result=null;
		try {
			// 핵심사항의 	return값을 전달받음
			result=joinpoint.proceed() ;
			// 정상종료	
			System.out.println("** 맛있게 먹기 => 핵심적 관심사항 정상종료 !!!");
		}catch (Throwable e) {
			// 핵심사항 비정상종료
			System.out.println("** 엄마한테 혼나요 ~~ => 예외 발생으로 핵심적 관심사항 비정상종료 !!!");
		}finally {
			// After
			System.out.println("** finally: 설겆이 하기 ~~ => 아무튼 최종 종료 !!");
		}
		return result; // 핵심관심사항의 return값 을 외부로 전달
	} // myAround
} // class
