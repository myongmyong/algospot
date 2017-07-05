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
	
 private static final int MINIMUM = 1;		// testcase 수행횟수 최소입력숫자
 private static final int CD_MINIMUM = 1;	// 좌표(coordinate) 최소값
 private static final int CD_MAXIMUM = 1000;	// 좌표(coordinate) 최대값
 
	Scanner scan = new Scanner(System.in);

	int T;					// testcase 수행횟수 입력받을 변수
	int cdArray[] = new int[6]; 		// 입력한 3종류의 좌표 저장할 배열
	int resultArray[] = null;		// 출력할 좌표 저장할 배열
	int index = 0;				// resultArray 인덱스 계산에 사용할 변수

	public void calc() 			// 좌표구하는 로직 메소드
	{

		
		/**
		 * 구하고자 하는 x좌표 계산 로직
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
		 * 구하고자 하는 y좌표 계산 로직
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

	public void input() 				// input 메소드
	{
		T = scan.nextInt();			// testcase T 입력
		resultArray = new int[T * 2];		// 구하고자 하는 좌표 저장할 배열 초기화

		if (T < MINIMUM)			// testcase 수행횟수인 T의 입력조건 검사
		{
			System.exit(1);
		}

		for (int i = 0; i < T; i++)
		{
			for (int j = 0; j < 6; j++)	// 직사각형 세쌍의 좌표(총 6개) 입력
			{
				cdArray[j] = scan.nextInt();
				
				if (cdArray[j] < CD_MINIMUM || cdArray[j] > CD_MAXIMUM) // 좌표 입력조건 검사
				{
					System.exit(1);
				}
			}

			calc();				// calc()메소드 호출
		}

		scan.close();				// Scanner클래스 메모리 해제
		output();				// output() 메소드 호출
	}

	public void output() 					// output 메소드
	{
		for (int z = 0; z < resultArray.length; z++)
		{
			System.out.print(resultArray[z]+" ");
		
			if (z % 2 == 1)				// 2번씩 출력하고 줄바꿈
			{
				System.out.println("");
			}
		}
	}

	public static void main(String[] args)
	{
		otherDrawrect main = new otherDrawrect();
		main.input();					//input메소드 호출
	}

}
