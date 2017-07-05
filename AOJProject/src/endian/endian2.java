package endian;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class endian2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		List<Integer> inputList = new ArrayList<Integer>();
		
		int init = sc.nextInt();
		
		for(int i=0;i<init;i++){
			inputList.add(sc.nextInt());
		}
		System.out.println(inputList);
	}
	
	public static List<Integer> converter(List<Integer> inputList){
		
		
		//Input값을 32bit binary code로 바꾸어 binList에 저장
		List<int[][]> binList = new ArrayList<int[][]>();
		int[][] arrBit = new int[4][8];
		
		for(int a=0;a<inputList.size();a++){
			
			int temp = inputList.get(a);
			int value;
			int left;
			
			for(int b=0;b<4;b++){
				for(int c=0;c<8;c++){
					value = temp/2;
					left = temp%2;
					
					arrBit[3-b][7-c] = left;
					temp = value;
				}
			}
			binList.add(arrBit);	
		}
		
		//Big-endian <--> Little-endian으로 변환
		int[][] tempBit = new int[4][8];
		
		for(int i=0;i<binList.size();i++){
			int[][] getBin = binList.get(i); 
			for(int j=0;j<4;j++){
				tempBit[j] = getBin[3-j];
			}
			binList.add(i, tempBit);
		}
		
		//binary code를 decimal code로 변환
		List<Integer> resultList = new ArrayList<Integer>();
		
		for(int x=0;x<binList.size();x++){
			
			int[][] tempBit2 = binList.get(x);
			int num;
			double decimalNum = 0;
			double exponent = 0;
			
			for(int y=0;y<4;y++){
				for(int z=0;z<8;z++){
					num = tempBit2[3-y][7-z];
					if(num == 1){
						decimalNum += Math.pow(2, exponent);
						exponent++;
					}else{
						decimalNum += 0;
						exponent++;
					}
				}
			}
			resultList.add((int)decimalNum);
		}
		
		return resultList;
	}
}