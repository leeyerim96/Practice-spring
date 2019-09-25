package aop05;

import org.aspectj.lang.JoinPoint;

//** xml 방식의 공통적 관심 사항 구현 4.
// => 핵심관심사항에 인자(매개변수) 와  return값이 있는 경우 
// => 개별 advice 메서드 구현
//    Before, After_returning, After_throwing, After 

//=> 핵심관심사항의 인자(매개변수) 와  return값의 처리
//1) 인자
//=> Around 에서는 ProceedingJoinPoint를 사용 하지만, 
// Before 메서드 에서는 ProceedingJoinPoint의 부모인
// JoinPoint를 사용하여 getArgs()메서드 접근해야함.
//2) return 값 처리
//=> After_returning 메서드에 매개변수로 전달됨. 

public class MyAspect {

	// Before 단계 : 핵심적 관심사항 수행이전
	// => 핵심관심사항의 인자(매개변수) 처리가능
	// => 핵심관심사항의 인자 출력 하기 
	public void myBefofre(JoinPoint joinpoint) {
		System.out.println("** 배 고파요 ~~~ => Before !!!");
		// 1) 인자 Test
		// => 핵심관심사항의 인자(매개변수)  출력 하기
		Object[] args = joinpoint.getArgs();
		for (Object o : args) {
			System.out.println("Before , 핵심사항의 매개변수 => " + o);
		}
	}

	// After_returning : 핵심적 관심사항 정상종료
	// 핵심적 관심사항 정상 종료후 결과 return 
	// => 이 결과를 매개변수로 전달 받으며 이에 대한 처리가 가능
	// 매개변수 : xml 에서 mapping
	
	// Test 1. 전달된 Return 값  사용가능함 
	// Test 2. class 의 main 실행시에는 전달된 return 값 출력 됨 확인
	public void myAfter_returning(Object result) {
		System.out.println("** myAfter_returning result Test =>"+result);
		result="Result Change";
		System.out.println("** myAfter_returning result change Test =>"+result);
		System.out.println("** 맛있게 먹기 => 핵심적 관심사항 정상종료 !!!");
	}
	
	// After_throwing : 핵심적 관심사항 비정상종료
	// 핵심적 관심사항 실행도중 예외발생시 예외메시지 return 
	// => 매개변수로 예외 메시지 전달받으면 이에 대한 처리 가능
	// => 매개변수 : xml 에서 mapping
	public void myAfter_throwing(Exception e) {
		System.out.println("** 엄마한테 혼나요 ~~ => 예외 발생으로 핵심적 관심사항 비정상종료 !!!");
		System.out.println("** myAfter_throwing Exception => "+e.toString());
	}

	// 핵심적 관심사항 수행이후 _after
	// => 정상 종료이건, 비정상 종료이건 무조건시행
	public void myAfter() {
		System.out.println("** finally: 설겆이 하기 ~~ => 아무튼 최종 종료 !!");
	}
} // class
