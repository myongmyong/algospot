package candleStickChart;

import java.util.Arrays;
import java.util.Scanner;

public class CandleStickChart {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int init = sc.nextInt();sc.nextLine();
		int[] resultArr = new int[init];
		int[] highestArr = null, lowestArr = null;
		
		if(init <= 0 || init > 50){
			System.out.println("TestCases 범위 오류 (1<= T <=50)");
			System.exit(0);
		}
		
		for(int i=0;i<init;i++){
			int testCase = sc.nextInt();sc.nextLine();
			highestArr = new int[testCase];
			lowestArr = new int[testCase];
			for(int j=0;j<testCase;j++){
				lowestArr[j] = sc.nextInt();
				highestArr[j] = sc.nextInt();sc.nextLine();
			}
			int returnValue = scoring(testCase,lowestArr,highestArr);
			resultArr[i] = returnValue;
		}
		
		sc.close();
		
		for(int result : resultArr){
			if(result == -1){
				System.out.println("Chart 범위 오류 (1<= t <=2000)");
			}else{
				System.out.println(result);							
			}
		}

	}
	
	public static int scoring(int testCase, int[] lowParam, int[] highParam){
		if(testCase < 1 || testCase > 2000){
			return -1;
		}
		Arrays.sort(lowParam);
		Arrays.sort(highParam);
		int lowest = lowParam[testCase - 1];
		int highest = highParam[0];
		int result = testCase * (highest-lowest);
		return result;
	}
}
