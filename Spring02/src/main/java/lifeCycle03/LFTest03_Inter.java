package lifeCycle03;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("ss")
class Sample implements InitializingBean, DisposableBean {
	public Sample() {System.out.println("** Sample ������ **"); }
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("** Sample begin �޼��� **"); 
	} 
	@Override
	public void destroy() throws Exception {
		System.out.println("** Sample end �޼��� **"); 
	} 
} // Sample

public class LFTest03_Inter {
	public static void main(String[] args) {
		AbstractApplicationContext sc = new 
				GenericXmlApplicationContext("lifeCycle03/applicationContext03.xml") ;
		Sample sam=(Sample)sc.getBean("ss");
		System.out.println("** LFTest03 main ���� **");
		sc.close();
		System.out.println("** LFTest03 after sc close !!! ������ **");
	}

}
