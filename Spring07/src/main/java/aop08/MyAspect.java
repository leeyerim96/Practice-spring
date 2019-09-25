package aop08;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//** @ ����� ������ ���� ���� ����
// => �ٽɰ��ɻ��׿� ����(�Ű�����) ��  return���� �ְ�
//    ���� �޼��� (advice �� ó��) ���
@Component
@Aspect
public class MyAspect {
	
	@Pointcut("execution(* doSomething(*))")
	public void myPoint() { }
	
	@Before("myPoint()")
	public void myBefofre(JoinPoint joinpoint) {
		System.out.println("** �� ���Ŀ� ~~~ => Before !!!");
		// 1) ���� Test
		// => �ٽɰ��ɻ����� ����(�Ű�����)  ��� �ϱ�
		Object[] args = joinpoint.getArgs();
		for (Object o : args) {
			System.out.println("Before , �ٽɻ����� �Ű����� => " + o);
		}
	}

	// Test 1. ���޵� Return ��  ��밡���� 
	// Test 2. class �� main ����ÿ��� ���޵� return �� ��� �� Ȯ��
	@AfterReturning(pointcut="myPoint()", returning="result")
	public void myAfter_returning(Object result) {
		System.out.println("** myAfter_returning result Test =>"+result);
		result="Result Change";
		System.out.println("** myAfter_returning result change Test =>"+result);
		System.out.println("** ���ְ� �Ա� => �ٽ��� ���ɻ��� �������� !!!");
	}
	
	@AfterThrowing(pointcut="myPoint()", throwing="e")
	public void myAfter_throwing(Exception e) {
		System.out.println("** �������� ȥ���� ~~ => ���� �߻����� �ٽ��� ���ɻ��� ���������� !!!");
		System.out.println("** myAfter_throwing Exception => "+e.toString());
	}

	// �ٽ��� ���ɻ��� �������� _after
	// => ���� �����̰�, ������ �����̰� �����ǽ���
	@After("myPoint()")
	public void myAfter() {
		System.out.println("** finally: ������ �ϱ� ~~ => �ƹ�ư ���� ���� !!");
	}
} // class
