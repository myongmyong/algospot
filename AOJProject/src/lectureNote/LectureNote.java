package lectureNote;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LectureNote {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int init = sc.nextInt();
		
		List<String> strList = new ArrayList<String>();
		
		while(init-->0){
			String str = sc.next();
			strList.add(str);
		}
		
		changeLoc(strList);
		
	}
	
	public static void changeLoc(List<String> inputList){
			
		for(String str : inputList){
			
			int rest = str.length()%2;
			int divide = str.length()/2;
			
			if(rest == 0){
				String[] divArr = new String[divide];

				for(int i=0;i<divide;i++){
					divArr[i] = str.substring(0,2);					
					str = str.substring(2);
				}
				
				int loc = 0;
				
				while(loc < divide){
					for(int j=loc;j<divide;j++){
						String temp;
						if(divArr[loc].compareTo(divArr[j]) > 0){
							temp = divArr[loc];
							divArr[loc] = divArr[j];
							divArr[j] = temp;
						}
					}
					loc++;
				}
								
				for(String a : divArr){
					System.out.print(a);
				}
				System.out.println();
				
				
			}else{
				System.out.println("2의 배수를 입력해주세요.");
			}
		}
	}
	
}