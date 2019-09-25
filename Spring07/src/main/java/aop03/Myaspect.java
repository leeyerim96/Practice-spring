package aop03;
// ** ������ ���� ���� ���� 1. => Ⱦ�� ���ɻ��� (cross concerns => Aspect )
// => xml ���
// => Around : method 1���� ó��
// Boy , Girl : �״�� ���
//Joinpoint Ŭ����
// => �ٽɰ��ɻ������� ���� ��� ������(before�� ����) ������ ������ ������ 

import org.aspectj.lang.ProceedingJoinPoint;

public class Myaspect {
	public void myAround(ProceedingJoinPoint joinpoint) { // ��������Ʈ�� �ٽ��� ���ɻ����� ������ ����?
		//Before
		System.out.println("** �� ���Ŀ� ~~~ => Before!!!");
		try {
			//�ٽɻ���
			joinpoint.proceed();
			//��������
			System.out.println(" ���ְ� �Ա�  => �ٽ��� ���ɻ��� �������� !!");
		} catch(Throwable e) {
			// �ٽɻ��� ����������
			System.out.println("** �������� ȥ����~~ => �ٽ��� ���ɻ��� ������ ����");
		}finally {
		// After
			System.out.println("**finally: ������ �ϱ� ~~ => �ƹ�ư ���� ����!!");
		}
	}
}// class
