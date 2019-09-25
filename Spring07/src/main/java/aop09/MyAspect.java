package aop09;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//**  @ ����� ������ ���� ���� ����
//=> �ٽɰ��ɻ��׿� ����(�Ű�����) ��  return���� �ִ� ��� 
//=> Around  

@Component
@Aspect
public class MyAspect {
	@Pointcut("execution(* do*(*))")
	public void myPoint() { }
	
	@Around("myPoint()")
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
