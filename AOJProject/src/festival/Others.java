package festival;

import java.util.Scanner;

public class Others {
	
	//대여 가능한 날들의 집합. 0번째는 항상 비워둔다.
	static int[] Cost = new int[1001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        //테스트 케이스
		int cases = sc.nextInt();
        
        while(cases-- > 0) {
        	int N = sc.nextInt();
        	int L = sc.nextInt();
        	
        	double min = Double.MAX_VALUE;
        	
        	for(int i=1; i<=N; i++) {
        		//첫 날부터 대여할 수 있는 날까지 대여료를 누적한다.
        		Cost[i] = Cost[i-1] + sc.nextInt();
        	}
        	
        	for(int i=0; i<=N-L; i++) {
        		//최소 j일 이상 공연해야 한다.
        		for(int j=L+i; j<=N; j++) {
        			//시작일부터 최소 j일까지의 대여료인 Cost[j]에서 시작일 전의 대여료인 Cost[i]를 감산한 후, 일수로 나눈다.
        			min = Math.min(min, (double)(Cost[j] - Cost[i]) / (j-i));
        		}
        	}
        	
        	System.out.printf("%.8f\n", min);
        
        }
        sc.close();
	}	
}
