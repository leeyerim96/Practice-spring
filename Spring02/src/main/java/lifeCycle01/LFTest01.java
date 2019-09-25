package lifeCycle01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// �ش�Ǵ� ������ �ڵ� ���� : xml, @, interface
// => xml �� �ش� �������� ��� : init-method="begin" destroy-method="end"

class Sample {
	public Sample() {System.out.println("** Sample ������ **"); }
	public void begin() {System.out.println("** Sample begin �޼��� **"); } 
	public void end() {System.out.println("** Sample end �޼��� **"); } 
	public void printName() {System.out.println("** Sample printName �޼��� **"); } 
	public void printId() {System.out.println("** Sample printId �޼��� **"); } 
} // Sample

public class LFTest01 {
	public static void main(String[] args) {
		AbstractApplicationContext sc = new 
				GenericXmlApplicationContext("lifeCycle01/applicationContext01.xml") ;
		Sample sam=(Sample)sc.getBean("ss");
		sam.printId();
		sam.printName();
		System.out.println("** LFTest01 main ������ �� ���� **");
		sc.close();
	}

}
