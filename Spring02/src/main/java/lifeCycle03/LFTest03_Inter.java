package lifeCycle03;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("ss")
class Sample implements InitializingBean, DisposableBean {
	public Sample() {System.out.println("** Sample 생성자 **"); }
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("** Sample begin 메서드 **"); 
	} 
	@Override
	public void destroy() throws Exception {
		System.out.println("** Sample end 메서드 **"); 
	} 
} // Sample

public class LFTest03_Inter {
	public static void main(String[] args) {
		AbstractApplicationContext sc = new 
				GenericXmlApplicationContext("lifeCycle03/applicationContext03.xml") ;
		Sample sam=(Sample)sc.getBean("ss");
		System.out.println("** LFTest03 main 실행 **");
		sc.close();
		System.out.println("** LFTest03 after sc close !!! 하하하 **");
	}

}
