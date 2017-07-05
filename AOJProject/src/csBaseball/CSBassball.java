package csBaseball;

import java.util.Scanner;

public class CSBassball {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int init = sc.nextInt();sc.nextLine();
		int[][] paramArr = new int[init][2];
		
		for(int i=0;i<init;i++){
			paramArr[i][0] = sc.nextInt();
			paramArr[i][1] = sc.nextInt();sc.nextLine();
		}
		
		cal(paramArr);
		
	}
	
	public static void cal(int[][] param){
		int len = param.length;
		
		for(int i=0;i<len;i++){
			int x = param[i][0];
			int y = param[i][1];
			if(x > y){
				System.out.println(0);
			}else{
				System.out.println((y-x) + 4);
			}
		}
		
	}

}
