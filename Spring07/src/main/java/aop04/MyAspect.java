package aop04;

import org.aspectj.lang.ProceedingJoinPoint;

//** xml ����� ������ ���� ���� ���� 3. 
//=> �ٽɰ��ɻ��׿� ����(�Ű�����) ��  return���� �ִ� ��� 
//=> Around : method 1���� ó��
//1) ����
//=> ProceedingJoinPoint�� getArgs() �޼���
//   �ٽɰ��ɻ����� ����(�Ű�����) �� ����� �迭�� ���·� ������.
//   around �޼��� ������ ��밡����.
//   ProceedingJoinPoint �� �θ��� JoinPoint Ŭ������ �����Ǿ�����.
//2) return �� ó��
//=> around �޼��� ������ ��� �����ϰ�,
//=> �ݵ�� return ���־�� ��.
//   ProceedingJoinPoint�� proceed() �޼��� 
//   -> �ٽ��� ���ɻ����� return �� ���� ����
 
public class MyAspect {
	
	public Object myAround(ProceedingJoinPoint joinpoint) {
		// Before
		System.out.println("** �� ���Ŀ� ~~~ => Before !!!");
		//1) ���� Test
		Object [] args=joinpoint.getArgs();
		for (Object o:args) {
			System.out.println("Before , �ٽɻ����� �Ű����� => "+o);
		}
		//2) �ٽ��� ���ɻ����� return �� Test
		// 2.1) result ����
		Object result=null;
		try {
			// �ٽɻ����� 	return���� ���޹���
			result=joinpoint.proceed() ;
			// ��������	
			System.out.println("** ���ְ� �Ա� => �ٽ��� ���ɻ��� �������� !!!");
		}catch (Throwable e) {
			// �ٽɻ��� ����������
			System.out.println("** �������� ȥ���� ~~ => ���� �߻����� �ٽ��� ���ɻ��� ���������� !!!");
		}finally {
			// After
			System.out.println("** finally: ������ �ϱ� ~~ => �ƹ�ư ���� ���� !!");
		}
		return result; // �ٽɰ��ɻ����� return�� �� �ܺη� ����
	} // myAround
} // class
