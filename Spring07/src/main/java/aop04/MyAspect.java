package aop04;

import org.aspectj.lang.ProceedingJoinPoint;

//** xml 방식의 공통적 관심 사항 구현 3. 
//=> 핵심관심사항에 인자(매개변수) 와  return값이 있는 경우 
//=> Around : method 1개로 처리
//1) 인자
//=> ProceedingJoinPoint의 getArgs() 메서드
//   핵심관심사항의 인자(매개변수) 의 목록을 배열의 형태로 제공함.
//   around 메서드 내에서 사용가능함.
//   ProceedingJoinPoint 의 부모인 JoinPoint 클래스에 구현되어있음.
//2) return 값 처리
//=> around 메서드 내에서 사용 가능하고,
//=> 반드시 return 해주어야 함.
//   ProceedingJoinPoint의 proceed() 메서드 
//   -> 핵심적 관심사항의 return 값 전달 가능
 
public class MyAspect {
	
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
