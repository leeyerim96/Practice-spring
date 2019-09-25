package aop06;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//** 공통적 관심 사항 구현 5.=> @ 방식
//@Aspect
//=> 현재 빈에 공통 관심사항이 구현되어 있음을 스프링에 알리는 애노테이션
//   즉, 스프링 컨테이너가 MyAspect를  Aspect 객체로 인식하게 해줌
//=> 포인트컷과 어드바이스의 결합 이므로 @Aspect 가 설정된 Aspect 객체에는  
//=> 반드시 포인트컷과 어드바이스를 결합하는 설정이 있어야 함.
//=> 포인트컷을 설정하기위해서는 더미메서드를 사용해야함. 
//   (몸체가 없이 단순히 포인트컷을 식별하는 용도로만 쓰이는 더미 메서드)

@Component
@Aspect
public class MyAspect {
	@Pointcut("execution(void doSomething())")
	public void myPoint() { }
	
	// 핵심적 관심사항 수행이전 _before
	@Before("myPoint()")
	public void myBefofre() {
		System.out.println("** 배 고파요 ~~~ => Before !!!");
	}
	// 핵심적 관심사항 정상종료
	@AfterReturning("myPoint()")
	public void myAfter_returning() {
		System.out.println("** 맛있게 먹기 => 핵심적 관심사항 정상종료 !!!");
	}
	// 핵심적 관심사항 비정상종료
	@AfterThrowing("myPoint()")
	public void myAfter_throwing() {
		System.out.println("** 엄마한테 혼나요 ~~ => 예외 발생으로 핵심적 관심사항 비정상종료 !!!");
	}
	// 핵심적 관심사항 수행이후 _after
	@After("myPoint()")
	public void myAfter() {
		System.out.println("** finally: 설겆이 하기 ~~ => 아무튼 최종 종료 !!");
	}
	// => @ 으로 Test시에는 @After가  @AfterThrowing 보다 먼저 실행됨
	//    즉, pointcut 실행 이후에 실행됨 (aop02 의 ~.xml 참고 )
	//    after 가 final 을 의미하는것은 아님.
} // class
