package 알고리듬수업.week_10;

import java.util.Scanner;

//1,2,3
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] fibo = new int[n+1];

        fibo[1] = 1;
        fibo[2] = 2;
        fibo[3] = 4;

        for (int i = 4; i <= n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2] + fibo[i - 3];
        }
        System.out.println(fibo[n]);
    }
}

