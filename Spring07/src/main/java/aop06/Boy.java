package aop06;

import java.util.Random;

import org.springframework.stereotype.Component;
//=> �ٽ� ���ɻ��� (core concerns) �� �����ϸ� ��.
@Component("cookerb")
public class Boy implements Person {
	
	@Override
	public void doSomething() throws Exception {
		System.out.println("** ¥��� ����� => �ٽ��� ���ɻ��� !!!");
		// if (new Random().nextBoolean()) {
		if (false) {	
			// ������Ȳ
			throw new Exception("~~ Ȧ�� �� �¿��� ~~~") ;
		}
	} // doSomething()
} // class
