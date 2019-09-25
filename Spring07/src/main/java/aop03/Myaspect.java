package aop03;
// ** 공통적 관심 사항 구현 1. => 횡적 관심사항 (cross concerns => Aspect )
// => xml 방식
// => Around : method 1개로 처리
// Boy , Girl : 그대로 사용
//Joinpoint 클래스
// => 핵심관심사항으로 들어가는 모든 데이터(before를 통해) 사항을 가지고 있으며 

import org.aspectj.lang.ProceedingJoinPoint;

public class Myaspect {
	public void myAround(ProceedingJoinPoint joinpoint) { // 조인포인트가 핵심적 관심사항을 가지고 있음?
		//Before
		System.out.println("** 배 고파요 ~~~ => Before!!!");
		try {
			//핵심사항
			joinpoint.proceed();
			//정상종료
			System.out.println(" 맛있게 먹기  => 핵심적 관심사항 정상종료 !!");
		} catch(Throwable e) {
			// 핵심사항 비정상종료
			System.out.println("** 엄마한테 혼나요~~ => 핵심적 관심사항 비정상 종료");
		}finally {
		// After
			System.out.println("**finally: 설겆이 하기 ~~ => 아무튼 최종 종료!!");
		}
	}
}// class
