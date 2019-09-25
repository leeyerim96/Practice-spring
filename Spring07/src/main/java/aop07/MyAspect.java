package aop07;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//** @ ����� ������ ���� ���� ����  
// => �Ű�����, return ���� Around ���

@Component
@Aspect
public class MyAspect {
	@Pointcut("execution(void doSomething())")
	public void myPoint() { }
	
	@Around("myPoint()")
	public void myAround(ProceedingJoinPoint joinpoint) {
		// Before
		System.out.println("** �� ���Ŀ� ~~~ => Before !!!");
		try {
			// �ٽɻ���	
			joinpoint.proceed() ;
			// ��������	
			System.out.println("** ���ְ� �Ա� => �ٽ��� ���ɻ��� �������� !!!");
		}catch (Throwable e) {
			// �ٽɻ��� ����������
			System.out.println("** �������� ȥ���� ~~ => ���� �߻����� �ٽ��� ���ɻ��� ���������� !!!");
		}finally {
			// After
			System.out.println("** finally: ������ �ϱ� ~~ => �ƹ�ư ���� ���� !!");
		}
	} // myAround
} // class
