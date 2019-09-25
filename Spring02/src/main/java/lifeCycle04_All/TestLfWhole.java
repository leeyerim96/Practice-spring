package lifeCycle04_All;

import javax.annotation.*;

import org.springframework.beans.factory.*;
import org.springframework.context.support.*;

class Sample implements InitializingBean,DisposableBean{
	public Sample(){
		System.out.println("Sample Ŭ����  ===> ������");
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
			("***Sample�� �������̽� �޼ҵ�:afterPropertiesSet()");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("===Sample�� �������̽� �޼ҵ�:destroy()");		
	}
	
}

public class TestLfWhole {

	public static void main(String[] args) {
		AbstractApplicationContext ff 
		= new GenericXmlApplicationContext
				("lifeCycle04_All/applicationContext.xml");
		
		Sample s = (Sample)ff.getBean("sample");
		System.out.println("TestLifeCycle Ŭ����  ===> main");
		ff.close();
	}
}







