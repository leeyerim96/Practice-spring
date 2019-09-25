package aop02;
// ** ������ ���� ���� ���� 1. => Ⱦ�� ���ɻ��� (cross concerns => Aspect )
// => xml ���
// Boy , Girl => �ٽ� ���ɻ��� (core concerns)�� �����ϸ� ��.

public class Myaspect {
		//�ٽ��� ���ɻ��� ��������_before
		public void myBefore() {
			System.out.println("** �� ���Ŀ� ~~~ => Before!!!");
		}
		
		// �ٽ��� ���ɻ��� ��������
		public void myAfter_returning() {
			System.out.println(" ���ְ� �Ա�  => �ٽ��� ���ɻ��� �������� !!");
		}
		
		// �ٽ��� ���ɻ��� ����������
		public void myAfter_throwing() {
			System.out.println("** �������� ȥ����~~ => �ٽ��� ���ɻ��� ������ ����");
		}
		
		// �ٽ��� ���ɻ��� �������� _after
		// => ���� �����̰�, ������ �����̰� ������ ����
		public void myAfter() {
			System.out.println("**finally: ������ �ϱ� ~~ => �ƹ�ư ���� ����!!");
		}
		
		
} // class
