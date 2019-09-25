package aop02;
// ** 공통적 관심 사항 구현 1. => 횡적 관심사항 (cross concerns => Aspect )
// => xml 방식
// Boy , Girl => 핵심 관심사항 (core concerns)만 구현하면 됨.

public class Myaspect {
		//핵심적 관심사항 수행이전_before
		public void myBefore() {
			System.out.println("** 배 고파요 ~~~ => Before!!!");
		}
		
		// 핵심적 관심사항 정상종료
		public void myAfter_returning() {
			System.out.println(" 맛있게 먹기  => 핵심적 관심사항 정상종료 !!");
		}
		
		// 핵심적 관심사항 비정상종료
		public void myAfter_throwing() {
			System.out.println("** 엄마한테 혼나요~~ => 핵심적 관심사항 비정상 종료");
		}
		
		// 핵심적 관심사항 수행이후 _after
		// => 정상 종료이건, 비정상 종료이건 무조건 시행
		public void myAfter() {
			System.out.println("**finally: 설겆이 하기 ~~ => 아무튼 최종 종료!!");
		}
		
		
} // class
