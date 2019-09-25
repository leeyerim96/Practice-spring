package aop01;

import java.util.Random;

public class Girl implements Person {
	@Override
	public void doSomething() {
		System.out.println("** �� ���Ŀ� ~~~ => Before!!!");
		
		try {
			System.out.println("** «�� ����� => �ٽ��� ���ɻ��� !!");
			if(new Random().nextBoolean()) { 
				//���� ��Ȳ
				throw new Exception("~~ Ȧ�� �� �¿��� ~~~ ");// ���� ���ϴ� ��Ȳ�� exception�� ������ �ϴ� ��
				
			}
			System.out.println("** ���ְ� �Ա� => �ٽ��� ���ɻ��� �������� !!!");
		} catch (Exception e) {
			System.out.println("Boy Exception =>"+e.toString());
			System.out.println("** �������� ȥ����~~ => �ٽ��� ���ɻ��� ������ ����" );
		}finally {
			System.out.println("**finally: ������ �ϱ� ~~ => �ƹ�ư ���� ����!!");
		}
	} //doSomething()
} // class
