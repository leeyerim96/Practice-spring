package aop05;

import org.aspectj.lang.JoinPoint;

//** xml ����� ������ ���� ���� ���� 4.
// => �ٽɰ��ɻ��׿� ����(�Ű�����) ��  return���� �ִ� ��� 
// => ���� advice �޼��� ����
//    Before, After_returning, After_throwing, After 

//=> �ٽɰ��ɻ����� ����(�Ű�����) ��  return���� ó��
//1) ����
//=> Around ������ ProceedingJoinPoint�� ��� ������, 
// Before �޼��� ������ ProceedingJoinPoint�� �θ���
// JoinPoint�� ����Ͽ� getArgs()�޼��� �����ؾ���.
//2) return �� ó��
//=> After_returning �޼��忡 �Ű������� ���޵�. 

public class MyAspect {

	// Before �ܰ� : �ٽ��� ���ɻ��� ��������
	// => �ٽɰ��ɻ����� ����(�Ű�����) ó������
	// => �ٽɰ��ɻ����� ���� ��� �ϱ� 
	public void myBefofre(JoinPoint joinpoint) {
		System.out.println("** �� ���Ŀ� ~~~ => Before !!!");
		// 1) ���� Test
		// => �ٽɰ��ɻ����� ����(�Ű�����)  ��� �ϱ�
		Object[] args = joinpoint.getArgs();
		for (Object o : args) {
			System.out.println("Before , �ٽɻ����� �Ű����� => " + o);
		}
	}

	// After_returning : �ٽ��� ���ɻ��� ��������
	// �ٽ��� ���ɻ��� ���� ������ ��� return 
	// => �� ����� �Ű������� ���� ������ �̿� ���� ó���� ����
	// �Ű����� : xml ���� mapping
	
	// Test 1. ���޵� Return ��  ��밡���� 
	// Test 2. class �� main ����ÿ��� ���޵� return �� ��� �� Ȯ��
	public void myAfter_returning(Object result) {
		System.out.println("** myAfter_returning result Test =>"+result);
		result="Result Change";
		System.out.println("** myAfter_returning result change Test =>"+result);
		System.out.println("** ���ְ� �Ա� => �ٽ��� ���ɻ��� �������� !!!");
	}
	
	// After_throwing : �ٽ��� ���ɻ��� ����������
	// �ٽ��� ���ɻ��� ���൵�� ���ܹ߻��� ���ܸ޽��� return 
	// => �Ű������� ���� �޽��� ���޹����� �̿� ���� ó�� ����
	// => �Ű����� : xml ���� mapping
	public void myAfter_throwing(Exception e) {
		System.out.println("** �������� ȥ���� ~~ => ���� �߻����� �ٽ��� ���ɻ��� ���������� !!!");
		System.out.println("** myAfter_throwing Exception => "+e.toString());
	}

	// �ٽ��� ���ɻ��� �������� _after
	// => ���� �����̰�, ������ �����̰� �����ǽ���
	public void myAfter() {
		System.out.println("** finally: ������ �ϱ� ~~ => �ƹ�ư ���� ���� !!");
	}
} // class
