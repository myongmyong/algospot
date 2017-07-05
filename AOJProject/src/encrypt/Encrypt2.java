package encrypt;

import java.util.Scanner;

public class Encrypt2 {

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
			String even = "";
			String odd = "";
			char chr;
			for(int i=0;i<str.length();i++){
				chr = str.charAt(i);
				if(i%2 == 0){
					even += chr;
				}else{
					odd += chr;
				}
			}
			System.out.println(even+odd);
		}
	}
}
