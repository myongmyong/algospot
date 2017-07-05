package drawRect;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Drawrect {
	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		
		List<String[][]> verList = new ArrayList<String[][]>();
		
		int init = Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<init;i++){
			String[][] rectArr = new String[3][2];
			for(int j=0;j<3;j++){
				String vertex = sc.nextLine();
				String[] verArr = vertex.split(" ");
				rectArr[j] = verArr;
			}
			verList.add(rectArr);
		}
		
		draw(verList);
		
	}
	
	public static void draw(List<String[][]> inputList){
				
		String x,y;
		
		for(String[][] inputArr : inputList){
			
			if(inputArr[0][0].equals(inputArr[1][0])){
				x = inputArr[2][0];
			}else if(inputArr[0][0].equals(inputArr[2][0])){
				x = inputArr[1][0];
			}else{
				x = inputArr[0][0];
			}
			if(inputArr[0][1].equals(inputArr[1][1])){
				y = inputArr[2][1];
			}else if(inputArr[0][1].equals(inputArr[2][1])){
				y = inputArr[1][1];
			}else{
				y = inputArr[0][1];
			}
			System.out.println(x + " " + y);
		}	
	}	
}
