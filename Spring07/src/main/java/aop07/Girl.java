package aop07;

import java.util.Random;

import org.springframework.stereotype.Component;
//=> �ٽ� ���ɻ��� (core concerns) �� �����ϸ� ��.
@Component("cookerg")
public class Girl implements Person {
	@Override
	public void doSomething() throws Exception {
		System.out.println("** «�� ����� => �ٽ��� ���ɻ��� !!!");
		//if (new Random().nextBoolean()) {
		if (true) {	
			// ������Ȳ
			throw new Exception("~~ Ȧ�� �� �¿��� ~~~") ;
		}
	} // doSomething()
} // class
