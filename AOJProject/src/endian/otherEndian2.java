package endian;

import java.util.Scanner;

public class otherEndian2
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		long[] arrInput = new long[number];
		for (int i=0; i<number; i++)
			arrInput[i] = sc.nextLong();
		sc.close();

		long[] arrBinary  = new long[32];
		long[] arrConvert = new long[32];
		for (int i=0; i<number; i++) {
			int index = 31;
			do {
				arrBinary[index--] = arrInput[i]%2;
				arrInput[i] = arrInput[i] / 2;
			} while (arrInput[i] >= 2);
			arrBinary[index--] = arrInput[i];

			for (int j=index; j>=0; j--)
				arrBinary[j] = 0;

			for (int j=0; j<8; j++)
				arrConvert[j+24] = arrBinary[j];
			for (int j=8; j<16; j++)
				arrConvert[j+8] = arrBinary[j];
			for (int j=16; j<24; j++)
				arrConvert[j-8] = arrBinary[j];
			for (int j=24; j<32; j++)
				arrConvert[j-24] = arrBinary[j];

			long convert = 0;
			int multi = 1;
			for (int j=arrConvert.length-1; j>=0; j--) {
				convert += multi*arrConvert[j];
				multi *= 2;
			}
			System.out.println(String.valueOf(convert & 0xFFFFFFFFL));
		}
	}
}
