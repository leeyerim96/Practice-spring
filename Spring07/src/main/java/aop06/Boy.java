package aop06;

import java.util.Random;

import org.springframework.stereotype.Component;
//=> 핵심 관심사항 (core concerns) 만 구현하면 됨.
@Component("cookerb")
public class Boy implements Person {
	
	@Override
	public void doSomething() throws Exception {
		System.out.println("** 짜장면 만들기 => 핵심적 관심사항 !!!");
		// if (new Random().nextBoolean()) {
		if (false) {	
			// 오류상황
			throw new Exception("~~ 홀랑 다 태웠다 ~~~") ;
		}
	} // doSomething()
} // class
