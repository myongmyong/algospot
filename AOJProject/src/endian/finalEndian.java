package endian;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class finalEndian {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		List<Long> inputList = new ArrayList<Long>();
		
		int init = sc.nextInt();
		
		//�Է¹��� ���� inputList�� �����Ѵ�.
		for(int i=0;i<init;i++){
			inputList.add(sc.nextLong());
		}
		
		//��ȯ�� �������� ���ڸ� �����ϴ� ����Ʈ.
		List<Long> decimalList = toDecimal(changeLoc(toBinary(inputList)));
		
		for(long a:decimalList){
			System.out.println(a);
		}
		
	}
	
	
	//�Է¹��� ����Ʈ�� ���߹迭�� ������ �޴� ����Ʈ�� ����� �޼ҵ��Դϴ�.
	//[{{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}}] <- �̷� ������ �����ϴ�.
	public static List<int[][]> toBinary(List<Long> inputList){
		List<int[][]> binList = new ArrayList<int[][]>();		//���߹迭�� �� ������ ���ڵ��� �����ϴ� ����Ʈ.
		
		for(int a=0;a<inputList.size();a++){					//�Ű������� ���� ����Ʈ�� ũ�⸸ŭ for�� ����.
			
			int[][] arrBit = new int[4][8];						//���������� ��ȯ�� ���ڵ��� �����Ѵ�.
			long temp = inputList.get(a);						//�Ű����� ����Ʈ���� ������ ���� temp�� ����.
			long value;                                         //��� �������� ����
			int left;                                           
			
			for(int b=0;b<4;b++){								//2�� �������鼭 ���߹迭 �� ���ڸ�, �� [3][7]�������� �����Ѵ�.
				for(int c=0;c<8;c++){
					value = temp/2;
					left = (int) temp%2;
					
					arrBit[3-b][7-c] = left;
					temp = value;
				}
			}
			binList.add(arrBit);								//�ϼ��� ���߹迭�� ����Ʈ�� �����Ѵ�.
		}
		return binList;
	}
	
	//������ ��ȯ�� ����Ʈ���� ���߹迭�� �����Ͽ� �ڸ��� �ٲٴ� �޼ҵ��Դϴ�.
	public static List<int[][]> changeLoc(List<int[][]> binList){
		
		List<int[][]> changeList = new ArrayList<int[][]>();
		
		for(int i=0;i<binList.size();i++){
			
			int[][] tempBit = new int[4][8];
			int[][] arrBin = binList.get(i);
			
			for(int j=0;j<4;j++){
				tempBit[j] = arrBin[3-j];							//������ ���߹迭�� ������ �Ųٷ� �ٲߴϴ�.
			}
			changeList.add(i,tempBit);								//�ٲ� ���߹迭�� ����Ʈ�� �����մϴ�.
		}
		return changeList;
	}
	
	//�ڸ��� �ٲ� ������ ���ڵ��� ���������� ��ȯ�ϴ� �޼ҵ��Դϴ�.
	public static List<Long> toDecimal(List<int[][]> binList){
		
		List<Long> decimalList = new ArrayList<Long>();				//������ ���ڵ��� ���� ����Ʈ.
		
		for(int x=0;x<binList.size();x++){
			
			int [][] tempBit = binList.get(x);
			int num;
			double decimalNum = 0;                                  //���������� ��ȯ�� ���� ������ ���� 
			double exponent = 0;									//����
			
			for(int y=0;y<4;y++){
				for(int z=0;z<8;z++){
					num = tempBit[3-y][7-z];
					if(num == 1){									//���߹迭�� �ڿ������� �˻��Ͽ� 1�� ���� decimalNum�� ���� 2�̰� ������ expnent�� ���� ���Ͽ� �����մϴ�.
						decimalNum += Math.pow(2, exponent);		//�̶� ������ �ϳ��� ������ŵ�ϴ�.
						exponent++;
					}else{
						decimalNum += 0;							//���� 0�� ���� decimalNum�� 0�� ���մϴ�.
						exponent++;                                 //�̶��� ������ ������ŵ�ϴ�.
					}
				}
			}
			decimalList.add((long)decimalNum);						//decimalNum�� long���� ĳ�����Ͽ� ����Ʈ�� �����մϴ�.
		}
		
		return decimalList;
	}
}