package mispell;

import java.util.Scanner;

public class Mispell {
	public static void main(String[] args){
				
		Scanner sc = new Scanner(System.in);
		int init = sc.nextInt();
		sc.nextLine();
		String[] paramArr = new String[init];
		
		// Datasets의 범위가 1~1000사이에 있도록함
		if(init < 0 || init > 1000){
			System.out.println("입력 범위 오류!!!");
			System.exit(1);
		}
		
		//[(삭제할 인덱스)(공백)(대상 문자열)]의 형태.
		//Dataset의 수만큼 문자열을 입력받는다.
		for(int i=0;i<init;i++){
			paramArr[i] = sc.nextLine().toUpperCase();
		}
		
		sc.close();
		
		misspell(paramArr);
	}
	
	public static void misspell(String[] param){
		int order = 0;
		for(String str : param){
			//문자열의 첫 번째 문자를 반환하여 숫자로 치환.
			int index = Integer.parseInt(str.substring(0, 1));
			//공백은 건너뛰고 문자열이 시작하는 부분부터 문자열로 반환하고 모두 대문자로 만든다.
			String misspell = str.substring(2);
			if(index < 0 || index > misspell.length()){
				System.out.println(++order + " 범위를 벗어납니다.");
				continue;
			}else if(misspell.length() > 80){
				System.out.println(++order + " 문자열의 길이가 깁니다.");
				continue;
			}else if(index == 1){
				//첫 번째 문자를 삭제할 경우.
				misspell = misspell.substring(1);
			}else if(index == str.length()){
				//마지막 문자를 삭제할 경우.
				misspell = misspell.substring(0,misspell.length()-1);
			}else{
				//중간의 문자열을 삭제할 경우.
				String a = misspell.substring(0,index-1);
				String b = misspell.substring(index);
				misspell = a + b;
			}
			//order는 반환되는 순서
			System.out.println(++order + " " + misspell);
		}
	}
}
