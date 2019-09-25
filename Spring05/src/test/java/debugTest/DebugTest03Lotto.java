package debugTest;

import java.util.Random;
// Lotto1 : Ž�� & ����
public class DebugTest03Lotto {
	// ** Random Ŭ���� �̿�
	// =>java.util �� �����Ƿ� import �� new ���� �ʿ���.
	// ver1. 1~45 ���� ������ 6���� ���� �ٸ� ������ �����Ͽ� �迭(lotto)�� ��� ����ϱ� 
	public static void main(String[] args) {
		// 1. Random Ŭ���� ����
		Random rc = new Random() ;
		// 2. 1~45 ���� ������ 6���� ������ ����  
		// 3. ���ϼ�(�ߺ�) Ȯ��
		// 4. �迭(lotto)�� ���
		//int[] lotto = new int[6] ;
		int lotto[] = new int[6] ;
		for (int i=0;i<lotto.length;i++) {
			lotto[i] = rc.nextInt(45)+1 ;
			// �ߺ�Ȯ�� => Ž�� , search 
			for (int j=0;j<i;j++) {
				if (lotto[i]==lotto[j]) {
					// i=i-1 => i-=1 => --i ;
					--i ;
					break ;
				} // if
			} // for_j
		} // for
		// 5. ������ ����ϱ�
		System.out.println("\n** ������ ����ϱ� **");
		for (int i:lotto) {
			System.out.printf("%d   ",i);
		}

		// Ver2. �������� ���� �ϱ� , Sort
		// => �������� Sequential Sort 	
		for (int i=0;i<lotto.length;i++) {
			for (int j=i+1;j<lotto.length;j++) {
				if (lotto[i] > lotto[j]) {  // ��������
				//if (lotto[i] < lotto[j]) {  // ��������
					// lotto[i] �� lotto[j]�� ���� �±�ȯ : ġȯ
					int temp = lotto[i] ;
					lotto[i] = lotto[j] ;
					lotto[j] = temp ;
				} // if
			} // for_j
		} // for_i

		System.out.println("\n** ������ ����ϱ� **");
		for (int i:lotto) {
			System.out.printf("%d   ",i);
		}

	} // main
} // class
