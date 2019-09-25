package debugTest;

public class DebugTest01 {
	public static void main(String[] args) {
		int d, m, n, n2, n3;
		d = 0;
		n = 2;
		
		// 1) 컴파일 오류 : 에디터에서 해결
		// n2 = n * n:  
		n2 = n * n;
		
		// 2) 런타임 오류 : 컴파일시에 발견할 수 없으나 Exeption 발생
		// => 인지 가능
		m = n / d; 

		// 3) 내용적 (논리적, logical) 오류 => Test 하지 않으면 알기 어려움
		
		n3 = n2 * n2;
		// n3에 n의 세제곱을 대입 한다고 가정,
		// 위의 경우 n3은 n의 4제곱이 되므로 논리적오류
		// => 컴파일오류 X, 런타임 Exeption X 
		// => 인지 어려움 : Test 필요.
		// 기본적 test 방법 => 실행도중 변수 값의 변화를 추적
		
		// => Debugging ( bug: 벌레, debug:(컴퓨터 프로그램에서) 오류를 검출하여 제거하다 )
		// =>1) Perspective 창 - Debug
		// =>2) 중단점(Breakpoint) 설정
		// - 원하는 라인의 거터(Gutter)영역에서 더블클릭 또는 마우스우클릭
		// - 다시 더블클릭하면 해제
		// =>3) 디버그 모드로 실행
		// => f11 또는 Run-Debug as 또는 벌레모양도구
		// => f5 : Step Into 한행씩 진행하며 메서드를만나면 내부로 진입
		// => f6 : Step Over 한행씩 진행하며 메서드를만나도 내부로 진입하지 않음.
		// => Ctrl+R : Run to Line 다음 중단점까지 프로그램 실행
		// => f8 : Resume 중단된 프로그램 다시 실행
		// => Ctrl+f2 : Terminate 디버그 모드로 실행을 종료 한다.

		//
	} // main
} // close