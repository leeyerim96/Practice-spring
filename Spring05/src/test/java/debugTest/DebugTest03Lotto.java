package debugTest;

import java.util.Random;
// Lotto1 : 탐색 & 정렬
public class DebugTest03Lotto {
	// ** Random 클래스 이용
	// =>java.util 에 있으므로 import 와 new 선언 필요함.
	// ver1. 1~45 범위 내에서 6개의 서로 다른 정수를 생성하여 배열(lotto)에 담고 출력하기 
	public static void main(String[] args) {
		// 1. Random 클래스 정의
		Random rc = new Random() ;
		// 2. 1~45 범위 내에서 6개의 정수를 생성  
		// 3. 동일성(중복) 확인
		// 4. 배열(lotto)에 담기
		//int[] lotto = new int[6] ;
		int lotto[] = new int[6] ;
		for (int i=0;i<lotto.length;i++) {
			lotto[i] = rc.nextInt(45)+1 ;
			// 중복확인 => 탐색 , search 
			for (int j=0;j<i;j++) {
				if (lotto[i]==lotto[j]) {
					// i=i-1 => i-=1 => --i ;
					--i ;
					break ;
				} // if
			} // for_j
		} // for
		// 5. 정렬전 출력하기
		System.out.println("\n** 정렬전 출력하기 **");
		for (int i:lotto) {
			System.out.printf("%d   ",i);
		}

		// Ver2. 오름차순 정렬 하기 , Sort
		// => 순차정렬 Sequential Sort 	
		for (int i=0;i<lotto.length;i++) {
			for (int j=i+1;j<lotto.length;j++) {
				if (lotto[i] > lotto[j]) {  // 오름차순
				//if (lotto[i] < lotto[j]) {  // 내림차순
					// lotto[i] 와 lotto[j]의 값을 맞교환 : 치환
					int temp = lotto[i] ;
					lotto[i] = lotto[j] ;
					lotto[j] = temp ;
				} // if
			} // for_j
		} // for_i

		System.out.println("\n** 정렬후 출력하기 **");
		for (int i:lotto) {
			System.out.printf("%d   ",i);
		}

	} // main
} // class
