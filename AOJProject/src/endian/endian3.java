package endian;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class endian3 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		List<Integer> inputList = new ArrayList<Integer>();
		
		int init = sc.nextInt();
		
		for(int i=0;i<init;i++){
			inputList.add(sc.nextInt());
		}
		
		List<Integer> decimalList = toDecimal(changeLoc(toBinary(inputList)));
		
		for(int a:decimalList){
			System.out.println(a);
		}
		
	}
	
	public static List<int[][]> toBinary(List<Integer> inputList){
		List<int[][]> binList = new ArrayList<int[][]>();
	
		for(int a=0;a<inputList.size();a++){
			
			int[][] arrBit = new int[4][8];		
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
		return binList;
	}
	
	public static List<int[][]> changeLoc(List<int[][]> binList){
		
		List<int[][]> changeList = new ArrayList<int[][]>();
		
		for(int i=0;i<binList.size();i++){
			
			int[][] tempBit = new int[4][8];
			int[][] arrBin = binList.get(i);
			
			for(int j=0;j<4;j++){
				tempBit[j] = arrBin[3-j];
			}
			changeList.add(i,tempBit);
		}
		return changeList;
	}
	
	public static List<Integer> toDecimal(List<int[][]> binList){
		
		List<Integer> decimalList = new ArrayList<Integer>();
		
		for(int x=0;x<binList.size();x++){
			
			int [][] tempBit = binList.get(x);
			int num;
			double decimalNum = 0;
			double exponent = 0;
			
			for(int y=0;y<4;y++){
				for(int z=0;z<8;z++){
					num = tempBit[3-y][7-z];
					if(num == 1){
						decimalNum += Math.pow(2, exponent);
						exponent++;
					}else{
						decimalNum += 0;
						exponent++;
					}
				}
			}
			decimalList.add((int)decimalNum);
		}
		
		return decimalList;
	}
}