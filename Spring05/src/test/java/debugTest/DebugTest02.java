package debugTest;

// => f5 : Step Into ���྿ �����ϸ� �޼��带������ ���η� ����
// => f6 : Step Over ���྿ �����ϸ� �޼��带������ ���η� �������� ����.
public class DebugTest02 {

	public static int moneyCount(int w, int c) {
		return w * c;
	} // moneyCount

	public static void main(String[] args) {
		// test 1.
		int year = 2018;
		++year;
		System.out.println(year++ + "�� ���� �� ���� ��������!");
		// test 2.
		int myMoney = moneyCount(1000, 8);
		myMoney += moneyCount(5000, 3);
		myMoney += moneyCount(10000, 6);
		myMoney += moneyCount(50000, 2);
		System.out.println("** Total myMoney => " + myMoney);
	} // main
} // class
