package drawRect;

import java.util.Scanner;
public class otherDrawrect2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int p1, p2;
        while(cnt-- > 0) {
            p1 = 0; p2 = 0;
            for (int i = 0; i < 3; i++) {
                p1 ^= sc.nextInt();
                p2 ^= sc.nextInt();
            }
            System.out.printf("%d %d\n", p1, p2);
        }
        sc.close();
    }
}