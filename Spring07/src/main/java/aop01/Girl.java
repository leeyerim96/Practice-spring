package aop01;

import java.util.Random;

public class Girl implements Person {
	@Override
	public void doSomething() {
		System.out.println("** 배 고파요 ~~~ => Before!!!");
		
		try {
			System.out.println("** 짬뽕 만들기 => 핵심적 관심사항 !!");
			if(new Random().nextBoolean()) { 
				//오류 상황
				throw new Exception("~~ 홀랑 다 태웠다 ~~~ ");// 내가 원하는 상황에 exception이 나도록 하는 것
				
			}
			System.out.println("** 맛있게 먹기 => 핵심적 관심사항 정상종료 !!!");
		} catch (Exception e) {
			System.out.println("Boy Exception =>"+e.toString());
			System.out.println("** 엄마한테 혼나요~~ => 핵심적 관심사항 비정상 종료" );
		}finally {
			System.out.println("**finally: 설겆이 하기 ~~ => 아무튼 최종 종료!!");
		}
	} //doSomething()
} // class
