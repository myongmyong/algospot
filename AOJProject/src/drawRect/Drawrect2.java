package drawRect;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Drawrect2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<int[][]> coordiList = new ArrayList<int[][]>();

		int init = sc.nextInt();

		if (init > 0) {
			for (int i = 0; i < init; i++) {
				int[][] coordiArr = new int[3][2];
				for (int j = 0; j < 3; j++) {
					int[] coordi = new int[2];
					for (int k = 0; k < 2; k++) {
						coordi[k] = sc.nextInt();
					}
					coordiArr[j] = coordi;
				}
				coordiList.add(coordiArr);
			}
		} else {
			System.out.println("테스트 케이스 수가 부족합니다.");
		}
		
		draw(coordiList);
	}

	public static void draw(List<int[][]> inputList){
				
		for(int[][] coordiArr : inputList){
			
			int x,y;
			
			for(int i=0;i<3;i++){
				int sum = coordiArr[i][0] + coordiArr[i][1];
				if(sum<1 || sum>2000){
					System.out.println("범위 오류.");
					System.exit(0);
				}
			}
			
			if(coordiArr[0][0] == coordiArr[1][0]){
				x = coordiArr[2][0];
			}else if(coordiArr[0][0] == coordiArr[2][0]){
				x = coordiArr[1][0];
			}else{
				x = coordiArr[0][0];
			}
			if(coordiArr[0][1] == coordiArr[1][1]){
				y = coordiArr[2][1];
			}else if(coordiArr[0][1] == coordiArr[2][1]){
				y = coordiArr[1][1];
			}else{
				y = coordiArr[0][1];
			}
			System.out.println(x + " " + y);
			
		}
		
	}
}