package iocDI03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

// 스프링이 제공하는 BeanFactory => Spring 컨테이너
// => @ , Annotation 어노테이션 활용 

//@ 사용방법
//1. xml에 context 네임스페이스 추가  [NameSpaces] 이용
//2. Component-scan 설정  : 
//	<context:component-scan base-package="d0714.iocEx05">
//		</context:component-scan>
//3. import 확인  => org.springframework.context.support.*;
//4. 생성 원하는 TV 클래스 위에 @Component("tv") 설정

//5.Test => 오류 메시지 확인 하기
//@ Test1 생성 -> <bean ... />
//@ Test2 id명 미 지정(둘다 beanname 없이) 
//=> ...NoSuchBeanDefinitionException: 
//      No bean named 'tv' is defined ....
//@ Test3 id명 중복되는 경우 (둘다 beanname  ("tv") 지정 )  
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
		System.out.println("** LgTV 생성 ~~");
	}
	
	public void powerOn() {
		System.out.println("** LgTV 전원 On");
	}
	public void powerOff() {
		System.out.println("** LgTV 전원 Off");
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
		System.out.println("** SsTV 생성 ~~");
	}
	
	public void powerOn() {
		System.out.println("** SsTV 전원 On");
	}
	public void powerOff() {
		System.out.println("** SsTV 전원 Off");
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
		// 1. Spring 컨테이너 구동
		AbstractApplicationContext sc = new
			GenericXmlApplicationContext("iocDI03/applicationC05.xml") ;	
		
		// 2. 필요한 객체를 설정화일을 이용해서 Spring 컨테이너 에게 요청 
		// => Spring 컨테이너는 getBean 를 실행해서 해당객체를 제공
		TV tv = (TV)sc.getBean("tv") ;
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		sc.close();
	} // main
} // class
