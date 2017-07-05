package hotSummer;

import java.util.Scanner;

public class HotSummer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int init = sc.nextInt();sc.nextLine();
		
		//limit -> 목표치, usage -> 시간당 사용량.
		int limit,usage;
		//건물별 목표치와 사용량의 합의 배열을 갖는 배열
		int[][] usageByBuilding = new int[init][2];
		
		//[[(목표치),(사용량의 합)]]으로 구성된 이중배열 생성
		for(int i=0;i<init;i++){
			limit = sc.nextInt();sc.nextLine();
			//초기 사용량은 0으로 초기화
			usage = 0;
			//건물별로 목표치를 저장.
			usageByBuilding[i][0] = limit;
			for(int j=0;j<10;j++){
				//시간당 사용량을 누적.
				usage += sc.nextInt();
			}
			usageByBuilding[i][1] = usage;
			sc.nextLine();
		}
		
		sc.close();
		
		checkUsage(usageByBuilding);
	}
		
	public static void checkUsage(int[][] paramArr){
		for(int[] targetArr : paramArr){
			//목표치와 사용량의 핪을 비교.
			if(targetArr[1] <= targetArr[0]){
				System.out.println("YES");
			}else{
				System.out.println("NO");				
			}
		}
	}

}
