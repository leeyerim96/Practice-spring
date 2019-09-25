package iocDI01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// 스프링이 제공하는 BeanFactory => Spring 컨테이너
// => 컨테이너는 설정화일의 설정정보 (<bean> 태그) 를 이용해서
//    빈(bean)객체를 생성하고 내부에 보관 

public class TVUser02_SpringF {

	public static void main(String[] args) {
		// 1. Spring 컨테이너 구동
		AbstractApplicationContext sc = new
			GenericXmlApplicationContext("iocDI01/applicationC02.xml") ;	
		
		// 2. 필요한 객체를 설정화일을 이용해서 Spring 컨테이너 에게 요청 
		// => Spring 컨테이너는 getBean 를 실행해서 해당객체를 제공
		TV tv = (TV)sc.getBean("mytv") ;
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		
		// 3. SingleTon Test 
		// => 스프링 프레임웤의 모든 작업은 싱글톤을 기본으로함.
		// => 싱글톤 (한개의 인스턴스만 허용 하는것) 적용 Test
		// => 각 TV 클래스에 생성자 추가 후,
		// => 설정화일의 scope 속성 에 "prototype" / "singleton" (default 는 싱글톤)
		// => 생성자가 한번 실행횟수와 아래의 주소값  확인
		TV tvs = (TV)sc.getBean("mytv") ;
		tvs.powerOn();
		TV tv1 = (TV)sc.getBean("mytv1") ;
		tv1.powerOn();
		TV tv2 = (TV)sc.getBean("mytv1") ;
		tv2.powerOn();
		
		System.out.println("** SingleTon Test : singleton tv  => "+tv);
		System.out.println("** SingleTon Test : singleton tvs => "+tvs);
		System.out.println("** SingleTon Test : prototype tv1 => "+tv1);
		System.out.println("** SingleTon Test : prototype tv2 => "+tv2);
		
		sc.close();
	} // main
} // class
