package aop08;

import java.util.Random;

import org.springframework.stereotype.Component;

//�ٽɰ��ɻ��׿� ����(�Ű�����) ��  return���� �ִ� ��� 
@Component("cookerb")
public class Boy implements Person {
	
	@Override
	public String doSomething(String s) throws Exception {
		System.out.println("** ¥��� " +s+"�κ� ����� => �ٽ��� ���ɻ��� !!!");
		// if (new Random().nextBoolean()) {
		if (false) {	
			// ������Ȳ
			throw new Exception("~~ Ȧ�� �� �¿��� ~~~") ;
		}
		return "¥����� ����� ~~~" ;
	} // doSomething()
} // class
