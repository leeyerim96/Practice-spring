package aop02;

import java.util.Random;

public class Boy implements Person {
	@Override
	public void doSomething() throws Exception {
			System.out.println("** ¥��� ����� => �ٽ��� ���ɻ��� !!");
			if(new Random().nextBoolean()) { 
				//���� ��Ȳ
				throw new Exception("~~ Ȧ�� �� �¿��� ~~~ ");// ���� ���ϴ� ��Ȳ�� exception�� ������ �ϴ� ��
				// ������� �ٽ��� ���ɻ��� try��
		} //doSomething()
	} // class
}