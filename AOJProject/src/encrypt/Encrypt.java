package encrypt;

import java.util.Scanner;

public class Encrypt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int init = sc.nextInt();
		String[] strArr = new String[init];
		
		for(int i=0;i<init;i++){
			strArr[i] = sc.next();
		}
		encrypter(strArr);
		sc.close();
	}
	
	
	public static void encrypter(String[] param){
		for(String str : param){
			String tmp = str;
			StringBuilder front = new StringBuilder();
			StringBuilder back = new StringBuilder();
			for(int i=0;i<str.length();i++){
				String token = tmp.substring(0, 1);
				if(i%2 == 0){
					front.append(token);
				}else{
					back.append(token);
				}
				tmp = tmp.substring(1);
			}
			System.out.println(front.append(back));	
		}
	}
}
