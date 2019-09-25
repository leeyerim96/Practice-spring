package aop06;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//** ������ ���� ���� ���� 5.=> @ ���
//@Aspect
//=> ���� �� ���� ���ɻ����� �����Ǿ� ������ �������� �˸��� �ֳ����̼�
//   ��, ������ �����̳ʰ� MyAspect��  Aspect ��ü�� �ν��ϰ� ����
//=> ����Ʈ�ư� �����̽��� ���� �̹Ƿ� @Aspect �� ������ Aspect ��ü����  
//=> �ݵ�� ����Ʈ�ư� �����̽��� �����ϴ� ������ �־�� ��.
//=> ����Ʈ���� �����ϱ����ؼ��� ���̸޼��带 ����ؾ���. 
//   (��ü�� ���� �ܼ��� ����Ʈ���� �ĺ��ϴ� �뵵�θ� ���̴� ���� �޼���)

@Component
@Aspect
public class MyAspect {
	@Pointcut("execution(void doSomething())")
	public void myPoint() { }
	
	// �ٽ��� ���ɻ��� �������� _before
	@Before("myPoint()")
	public void myBefofre() {
		System.out.println("** �� ���Ŀ� ~~~ => Before !!!");
	}
	// �ٽ��� ���ɻ��� ��������
	@AfterReturning("myPoint()")
	public void myAfter_returning() {
		System.out.println("** ���ְ� �Ա� => �ٽ��� ���ɻ��� �������� !!!");
	}
	// �ٽ��� ���ɻ��� ����������
	@AfterThrowing("myPoint()")
	public void myAfter_throwing() {
		System.out.println("** �������� ȥ���� ~~ => ���� �߻����� �ٽ��� ���ɻ��� ���������� !!!");
	}
	// �ٽ��� ���ɻ��� �������� _after
	@After("myPoint()")
	public void myAfter() {
		System.out.println("** finally: ������ �ϱ� ~~ => �ƹ�ư ���� ���� !!");
	}
	// => @ ���� Test�ÿ��� @After��  @AfterThrowing ���� ���� �����
	//    ��, pointcut ���� ���Ŀ� ����� (aop02 �� ~.xml ���� )
	//    after �� final �� �ǹ��ϴ°��� �ƴ�.
} // class
