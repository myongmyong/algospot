package festival;

import java.util.Scanner;

public class Festival {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int init = sc.nextInt();sc.nextLine();
		double[] resultArr = new double[init];
		
		if(init > 100){
			System.out.println("TestCase bound error. T <= 100");
			System.exit(0);
			
		}

		for(int i=0;i<init;i++){
			int n = sc.nextInt();
			int l = sc.nextInt();sc.nextLine();
			int[] unit = new int[n];
			for(int j=0;j<n;j++){
				unit[j] = sc.nextInt();
			}
			sc.nextLine();
			resultArr[i] = calMinCost(n, l, unit);
		}
		
		for(double result : resultArr){
			System.out.printf("%.11f\n",result);
		}
	}
	
	public static double calMinCost(int n, int l, int[] days){
		int i,j,num,cnt;
		//sum은 대여료의 합, avg는 1일 당 대여료 평균, cost는 최소비용을 갖는 변수.
		double sum,avg = 0.0d, cost = 0.0d;
		//
		for(i=0;i<n;i++){
			//i는 공연 시작일로, i가 (전체 대여 가능일수 - 최소 공연일수)보다 작아야한다.
			if(i <= n-l){
				//공연 일수에 따른 대여료의 합을 담는 변수
				sum = 0.0d;
				//공연일수를 담는 변수
				num = 0;
				for(j=i;j<n;j++){
					//sum은 j일부터 마지막날 까지의 대여료 합의 부분 집합을 구한다.
					sum += days[j];
					//avg는 대여료의 합을 대여 일수로 나눈다.
					avg = sum/(++num);
					//num이 최소 공연일수 이상이면서 cost가 초기값일 때 avg를 cost에 대입한다.
					if(cost == 0 && num >= l){
						cost = avg;
					//for문을 돌다가 avg의 값이 cost보다 낮고, 최소 공연일수 이상일 때, cost에 avg를 대입한다.	
					}else if(avg <= cost && num >= l){
						cost = avg;
					}
				}
			}
		}
		
		return cost;
	}
	
}
