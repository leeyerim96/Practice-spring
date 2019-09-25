package lifeCycle02;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("ss")
class Sample {
	public Sample() {System.out.println("** Sample 생성자 **"); }
	@PostConstruct
	public void begin() {System.out.println("** Sample begin 메서드 **"); } 
	@PreDestroy
	public void end() {System.out.println("** Sample end 메서드 **"); } 
} // Sample

public class LFTest02_Ano {
	public static void main(String[] args) {
		AbstractApplicationContext sc = new 
				GenericXmlApplicationContext("lifeCycle02/applicationContext02.xml") ;
		Sample sam=(Sample)sc.getBean("ss");
		System.out.println("** LFTest02 before 실행 **");
		sc.close();
		System.out.println("** LFTest02 after sc close !!! 하하하 **");
	}

}
