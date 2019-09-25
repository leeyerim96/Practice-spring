package aop04;

import java.util.Random;
//=> 핵심 관심사항 (core concerns) 만 구현하면 됨.
public class Girl implements Person {
	@Override
	public String doSomething(String s) throws Exception {
		System.out.println("** 짬뽕 "+s+"인분 만들기  => 핵심적 관심사항 !!!");
		//if (new Random().nextBoolean()) {
		if (true) {	
			// 오류상황
			throw new Exception("~~ 홀랑 다 태웠다 ~~~") ;
		}
		return "국물이 끝내주게 매워요 ~~~" ;
	} // doSomething()
} // class
