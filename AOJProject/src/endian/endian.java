package endian;

import java.util.Scanner;

public class endian {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		int[][] arrBit = new int[4][8];
		
		int temp = input;
		int value;
		int left;
				
		for(int i=0;i<4;i++){
			for(int j=0;j<8;j++){
				value = temp/2;
				left = temp%2;

				arrBit[3-i][7-j] = left;
				temp = value;	
			}		
		}
		
		int[][] tempBit = new int[4][8];
		
		for(int i=0;i<4;i++){
			tempBit[i] = arrBit[3-i];
		}
		
		double reverseNum = 0;
		double Exponent = 0;
		
		for(int i=0;i<4;i++){
			for(int j=0;j<8;j++){
				int num = tempBit[3-i][7-j];
				if(num == 1){
					reverseNum = reverseNum + Math.pow(2, Exponent);
					Exponent++;
				}else{
					reverseNum += 0;
					Exponent++;
				}
			}
		}
		
		System.out.println((int)reverseNum);
		
	}
}

























