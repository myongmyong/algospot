package endian;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class finalEndian {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		List<Long> inputList = new ArrayList<Long>();
		
		int init = sc.nextInt();
		
		//입력받은 수를 inputList에 저장한다.
		for(int i=0;i<init;i++){
			inputList.add(sc.nextLong());
		}
		
		//변환한 십진법의 숫자를 저장하는 리스트.
		List<Long> decimalList = toDecimal(changeLoc(toBinary(inputList)));
		
		for(long a:decimalList){
			System.out.println(a);
		}
		
	}
	
	
	//입력받은 리스트를 이중배열을 값으로 받는 리스트로 만드는 메소드입니다.
	//[{{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}}] <- 이런 구조를 가집니다.
	public static List<int[][]> toBinary(List<Long> inputList){
		List<int[][]> binList = new ArrayList<int[][]>();		//이중배열로 된 이진법 숫자들을 저장하는 리스트.
		
		for(int a=0;a<inputList.size();a++){					//매개변수로 받은 리스트의 크기만큼 for문 실행.
			
			int[][] arrBit = new int[4][8];						//이진법으로 변환한 숫자들을 저장한다.
			long temp = inputList.get(a);						//매개변수 리스트에서 가져온 값을 temp에 저장.
			long value;                                         //몫과 나머지를 선언
			int left;                                           
			
			for(int b=0;b<4;b++){								//2로 나눠가면서 이중배열 맨 뒷자리, 즉 [3][7]에서부터 저장한다.
				for(int c=0;c<8;c++){
					value = temp/2;
					left = (int) temp%2;
					
					arrBit[3-b][7-c] = left;
					temp = value;
				}
			}
			binList.add(arrBit);								//완성한 이중배열을 리스트에 저장한다.
		}
		return binList;
	}
	
	//위에서 변환한 리스트에서 이중배열을 추출하여 자리를 바꾸는 메소드입니다.
	public static List<int[][]> changeLoc(List<int[][]> binList){
		
		List<int[][]> changeList = new ArrayList<int[][]>();
		
		for(int i=0;i<binList.size();i++){
			
			int[][] tempBit = new int[4][8];
			int[][] arrBin = binList.get(i);
			
			for(int j=0;j<4;j++){
				tempBit[j] = arrBin[3-j];							//기존의 이중배열의 구조를 거꾸로 바꿉니다.
			}
			changeList.add(i,tempBit);								//바뀐 이중배열을 리스트에 저장합니다.
		}
		return changeList;
	}
	
	//자리를 바꾼 이진법 숫자들을 십진법으로 변환하는 메소드입니다.
	public static List<Long> toDecimal(List<int[][]> binList){
		
		List<Long> decimalList = new ArrayList<Long>();				//십진법 숫자들을 받을 리스트.
		
		for(int x=0;x<binList.size();x++){
			
			int [][] tempBit = binList.get(x);
			int num;
			double decimalNum = 0;                                  //십진법으로 변환된 수를 저장할 변수 
			double exponent = 0;									//지수
			
			for(int y=0;y<4;y++){
				for(int z=0;z<8;z++){
					num = tempBit[3-y][7-z];
					if(num == 1){									//이중배열의 뒤에서부터 검색하여 1일 경우는 decimalNum에 밑이 2이고 지수가 expnent인 값을 구하여 누적합니다.
						decimalNum += Math.pow(2, exponent);		//이때 지수를 하나씩 증가시킵니다.
						exponent++;
					}else{
						decimalNum += 0;							//값이 0일 경우는 decimalNum에 0을 더합니다.
						exponent++;                                 //이때도 지수를 증가시킵니다.
					}
				}
			}
			decimalList.add((long)decimalNum);						//decimalNum을 long으로 캐스팅하여 리스트에 저장합니다.
		}
		
		return decimalList;
	}
}