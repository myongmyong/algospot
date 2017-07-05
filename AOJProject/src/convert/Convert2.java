package convert;

import java.util.Scanner;

public class Convert2 {
	
	private final static double KG = 2.2046;
	private final static double LB = 0.4536;
	private final static double L = 0.2642;
	private final static double G = 3.7854;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int init = sc.nextInt(); sc.nextLine();
		String[] paramArr = new String[init];
		
		//1~1000의 범위 안에서만 입력하도록 함. 
		if(init<0 || init>1000){
			System.out.println("입력 범위 오류.");
			System.exit(0);
		}
		//[(무게||부피)(공백)(단위)]의 형태로 입력.
		for(int i=0;i<init;i++){
			String str = sc.nextLine();
			paramArr[i] = str;
		}
		
		converter(paramArr);
	}
	
	public static void converter(String[] paramArr){
		//출력순서
		int order = 0;
		//변환될 값을 담는 변수.
		double resultNum = 0;
		String unit = null;
		for(String target : paramArr){
			//공백을 기준으로 숫자와 단위를 나누어 배열로 만든다.
			String[] targetArr = target.split(" ");
			//무게||부피를 double형으로 변환.
			double targetNum = Double.parseDouble(targetArr[0]);
			if(targetArr[1].equals("kg")){
				resultNum = targetNum * KG;
				unit = "lb";
			}else if(targetArr[1].equals("lb")){
				resultNum = targetNum * LB;
				unit = "kg";
			}else if(targetArr[1].equals("l")){
				resultNum = targetNum * L;
				unit = "g";
			}else if(targetArr[1].equals("g")){
				resultNum = targetNum * G;
				unit = "l";
			}else{
				System.out.println("단위 입력 오류.");
				System.exit(0);
			}
			System.out.printf("%d %.4f %s \n",++order,resultNum,unit);
		}		
	}
}
