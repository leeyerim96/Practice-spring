package aop02;

import java.util.Random;

public class Girl implements Person {
	@Override
	public void doSomething() throws Exception {
		System.out.println("** 짬뽕 만들기 => 핵심적 관심사항 !!");
		if(new Random().nextBoolean()) { 
			//오류 상황
			throw new Exception("~~ 홀랑 다 태웠다 ~~~ ");// 내가 원하는 상황에 exception이 나도록 하는 것
			}
		}
} // class
