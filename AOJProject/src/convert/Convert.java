package convert;

import java.util.Scanner;

public class Convert {
	
	private final static double KG = 2.2046;
	private final static double LB = 0.4536;
	private final static double L = 0.2642;
	private final static double G = 3.7854;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int init = sc.nextInt(); sc.nextLine();
		String[] paramArr = new String[init];
		
		if(init<0 || init>1000){
			System.out.println("입력 범위 오류.");
			System.exit(0);
		}
		
		for(int i=0;i<init;i++){
			String str = sc.nextLine();
			paramArr[i] = str;
		}
		
		converter(paramArr);
	}
	
	public static void converter(String[] paramArr){
		int order = 0;
		for(String target : paramArr){
			String[] targetArr = target.split(" ");
			double targetNum = Double.parseDouble(targetArr[0]);
			if(targetArr[1].equals("kg")){
				double resultNum = targetNum * KG;
				System.out.printf("%d %.4f lb \n",++order,resultNum);
			}else if(targetArr[1].equals("lb")){
				double resultNum = targetNum * LB;
				System.out.printf("%d %.4f kg \n",++order,resultNum);
			}else if(targetArr[1].equals("l")){
				double resultNum = targetNum * L;
				System.out.printf("%d %.4f g \n",++order,resultNum);
			}else if(targetArr[1].equals("g")){
				double resultNum = targetNum * G;
				System.out.printf("%d %.4f l \n",++order,resultNum);
			}else{
				System.out.println("단위가 맞지 않습니다.");
			}
		}
	}
}
