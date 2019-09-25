package aop08;

import java.util.Random;

import org.springframework.stereotype.Component;

//핵심관심사항에 인자(매개변수) 와  return값이 있는 경우 
@Component("cookerb")
public class Boy implements Person {
	
	@Override
	public String doSomething(String s) throws Exception {
		System.out.println("** 짜장면 " +s+"인분 만들기 => 핵심적 관심사항 !!!");
		// if (new Random().nextBoolean()) {
		if (false) {	
			// 오류상황
			throw new Exception("~~ 홀랑 다 태웠다 ~~~") ;
		}
		return "짜장면은 살찐다 ~~~" ;
	} // doSomething()
} // class
