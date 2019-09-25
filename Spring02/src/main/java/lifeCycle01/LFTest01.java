package lifeCycle01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// 해당되는 시점에 자동 실행 : xml, @, interface
// => xml 에 해당 시점별로 등록 : init-method="begin" destroy-method="end"

class Sample {
	public Sample() {System.out.println("** Sample 생성자 **"); }
	public void begin() {System.out.println("** Sample begin 메서드 **"); } 
	public void end() {System.out.println("** Sample end 메서드 **"); } 
	public void printName() {System.out.println("** Sample printName 메서드 **"); } 
	public void printId() {System.out.println("** Sample printId 메서드 **"); } 
} // Sample

public class LFTest01 {
	public static void main(String[] args) {
		AbstractApplicationContext sc = new 
				GenericXmlApplicationContext("lifeCycle01/applicationContext01.xml") ;
		Sample sam=(Sample)sc.getBean("ss");
		sam.printId();
		sam.printName();
		System.out.println("** LFTest01 main 마지막 행 실행 **");
		sc.close();
	}

}
