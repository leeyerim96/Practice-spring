package aop09;

import java.util.Random;

import org.springframework.stereotype.Component;
//=> �ٽ� ���ɻ��� (core concerns) �� �����ϸ� ��.
@Component("cookerg")
public class Girl implements Person {
	@Override
	public String doSomething(String s) throws Exception {
		System.out.println("** «�� "+s+"�κ� �����  => �ٽ��� ���ɻ��� !!!");
		//if (new Random().nextBoolean()) {
		if (true) {	
			// ������Ȳ
			throw new Exception("~~ Ȧ�� �� �¿��� ~~~") ;
		}
		return "������ �����ְ� �ſ��� ~~~" ;
	} // doSomething()
} // class
