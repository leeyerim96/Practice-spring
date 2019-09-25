package lifeCycle04_All;

import javax.annotation.*;

import org.springframework.beans.factory.*;
import org.springframework.context.support.*;

class Sample implements InitializingBean,DisposableBean{
	public Sample(){
		System.out.println("Sample 클래스  ===> 생성자");
	}

	public void begin_xml(){
		System.out.println("***begin_xml()");
	}
	@PostConstruct
	public void begin_annotation(){
		System.out.println("***begin_annotation()");
	}
	
	public void end_xml(){
		System.out.println("===end_xml()");
	}
	
	@PreDestroy
	public void end_annotation(){
		System.out.println("===end_annotation()");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println
			("***Sample의 인터페이스 메소드:afterPropertiesSet()");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("===Sample의 인터페이스 메소드:destroy()");		
	}
	
}

public class TestLfWhole {

	public static void main(String[] args) {
		AbstractApplicationContext ff 
		= new GenericXmlApplicationContext
				("lifeCycle04_All/applicationContext.xml");
		
		Sample s = (Sample)ff.getBean("sample");
		System.out.println("TestLifeCycle 클래스  ===> main");
		ff.close();
	}
}







