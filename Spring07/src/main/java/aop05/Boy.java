package aop05;

import java.util.Random;

//�ٽɰ��ɻ��׿� ����(�Ű�����) ��  return���� �ִ� ��� 
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
