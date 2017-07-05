package drawRect;

import java.util.Scanner;


/**
 * <pre>
 * AlgoSpot Quiz in tutorial
 * DRAWRECT https://algospot.com/judge/problem/read/DRAWRECT
 * </pre>
 *
 * @author "Lee Shin Ho"
 */	

public class otherDrawrect {
	
 private static final int MINIMUM = 1;		// testcase ����Ƚ�� �ּ��Է¼���
 private static final int CD_MINIMUM = 1;	// ��ǥ(coordinate) �ּҰ�
 private static final int CD_MAXIMUM = 1000;	// ��ǥ(coordinate) �ִ밪
 
	Scanner scan = new Scanner(System.in);

	int T;					// testcase ����Ƚ�� �Է¹��� ����
	int cdArray[] = new int[6]; 		// �Է��� 3������ ��ǥ ������ �迭
	int resultArray[] = null;		// ����� ��ǥ ������ �迭
	int index = 0;				// resultArray �ε��� ��꿡 ����� ����

	public void calc() 			// ��ǥ���ϴ� ���� �޼ҵ�
	{

		
		/**
		 * ���ϰ��� �ϴ� x��ǥ ��� ����
		 **/
		
		if(cdArray[0] != cdArray[2] && cdArray[0] != cdArray[4])
		{
			resultArray[index] = cdArray[0];
		}
		else if(cdArray[2] != cdArray[0] && cdArray[2] != cdArray[4])
		{
			resultArray[index] = cdArray[2];
		}
		else
		{
			resultArray[index] = cdArray[4];
		}

		index++;

		
		
		/**
		 * ���ϰ��� �ϴ� y��ǥ ��� ����
		 **/
		
		if (cdArray[1] != cdArray[3] && cdArray[1] != cdArray[5])
		{
			resultArray[index] = cdArray[1];
		} 
		else if (cdArray[3] != cdArray[1] && cdArray[3] != cdArray[5])
		{
			resultArray[index] = cdArray[3];
		} 
		else
		{
			resultArray[index] = cdArray[5];
		}
		
		index++;

	}

	public void input() 				// input �޼ҵ�
	{
		T = scan.nextInt();			// testcase T �Է�
		resultArray = new int[T * 2];		// ���ϰ��� �ϴ� ��ǥ ������ �迭 �ʱ�ȭ

		if (T < MINIMUM)			// testcase ����Ƚ���� T�� �Է����� �˻�
		{
			System.exit(1);
		}

		for (int i = 0; i < T; i++)
		{
			for (int j = 0; j < 6; j++)	// ���簢�� ������ ��ǥ(�� 6��) �Է�
			{
				cdArray[j] = scan.nextInt();
				
				if (cdArray[j] < CD_MINIMUM || cdArray[j] > CD_MAXIMUM) // ��ǥ �Է����� �˻�
				{
					System.exit(1);
				}
			}

			calc();				// calc()�޼ҵ� ȣ��
		}

		scan.close();				// ScannerŬ���� �޸� ����
		output();				// output() �޼ҵ� ȣ��
	}

	public void output() 					// output �޼ҵ�
	{
		for (int z = 0; z < resultArray.length; z++)
		{
			System.out.print(resultArray[z]+" ");
		
			if (z % 2 == 1)				// 2���� ����ϰ� �ٹٲ�
			{
				System.out.println("");
			}
		}
	}

	public static void main(String[] args)
	{
		otherDrawrect main = new otherDrawrect();
		main.input();					//input�޼ҵ� ȣ��
	}

}
