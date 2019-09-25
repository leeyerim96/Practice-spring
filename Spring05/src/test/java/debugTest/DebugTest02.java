package debugTest;

// => f5 : Step Into 한행씩 진행하며 메서드를만나면 내부로 진입
// => f6 : Step Over 한행씩 진행하며 메서드를만나도 내부로 진입하지 않음.
public class DebugTest02 {

	public static int moneyCount(int w, int c) {
		return w * c;
	} // moneyCount

	public static void main(String[] args) {
		// test 1.
		int year = 2018;
		++year;
		System.out.println(year++ + "년 새해 복 많이 받으세요!");
		// test 2.
		int myMoney = moneyCount(1000, 8);
		myMoney += moneyCount(5000, 3);
		myMoney += moneyCount(10000, 6);
		myMoney += moneyCount(50000, 2);
		System.out.println("** Total myMoney => " + myMoney);
	} // main
} // class
