package iocDI03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

// �������� �����ϴ� BeanFactory => Spring �����̳�
// => @ , Annotation ������̼� Ȱ�� 

//@ �����
//1. xml�� context ���ӽ����̽� �߰�  [NameSpaces] �̿�
//2. Component-scan ����  : 
//	<context:component-scan base-package="d0714.iocEx05">
//		</context:component-scan>
//3. import Ȯ��  => org.springframework.context.support.*;
//4. ���� ���ϴ� TV Ŭ���� ���� @Component("tv") ����

//5.Test => ���� �޽��� Ȯ�� �ϱ�
//@ Test1 ���� -> <bean ... />
//@ Test2 id�� �� ����(�Ѵ� beanname ����) 
//=> ...NoSuchBeanDefinitionException: 
//      No bean named 'tv' is defined ....
//@ Test3 id�� �ߺ��Ǵ� ��� (�Ѵ� beanname  ("tv") ���� )  
//=> ...annotation.ConflictingBeanDefinitionException: ....
// ...non-compatible bean definition of same name and class ...


interface TV {
	public void powerOn();
	public void powerOff();
	public void volumeUp();
	public void volumeDown();
}

//@Component("tv")
class LgTV implements TV {
	
	public LgTV() {
		System.out.println("** LgTV ���� ~~");
	}
	
	public void powerOn() {
		System.out.println("** LgTV ���� On");
	}
	public void powerOff() {
		System.out.println("** LgTV ���� Off");
	}
	public void volumeUp() {
		System.out.println("** LgTV volumeUp");
	}
	public void volumeDown() {
		System.out.println("** LgTV volumeDown");
	}
} // LgTV

@Component("tv")
class SsTV implements TV {
	
	public SsTV() {
		System.out.println("** SsTV ���� ~~");
	}
	
	public void powerOn() {
		System.out.println("** SsTV ���� On");
	}
	public void powerOff() {
		System.out.println("** SsTV ���� Off");
	}
	public void volumeUp() {
		System.out.println("** SsTV soundUp");
	}
	public void volumeDown() {
		System.out.println("** SsTV soundDown");
	}
} // SsTV

public class TVUser05_Ano01 {

	public static void main(String[] args) {
		// 1. Spring �����̳� ����
		AbstractApplicationContext sc = new
			GenericXmlApplicationContext("iocDI03/applicationC05.xml") ;	
		
		// 2. �ʿ��� ��ü�� ����ȭ���� �̿��ؼ� Spring �����̳� ���� ��û 
		// => Spring �����̳ʴ� getBean �� �����ؼ� �ش簴ü�� ����
		TV tv = (TV)sc.getBean("tv") ;
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		sc.close();
	} // main
} // class
