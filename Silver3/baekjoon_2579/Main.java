package Silver3.baekjoon_2579;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] score = new int[n+1];
        for (int i = 1; i <= n; i++) {
            score[i] = sc.nextInt();
        }

        /**
         * 반복문 이용한 풀이 (bottom - up)
         */

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = score[1];
        if (n >= 2) {
            dp[2] = score[1] + score[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(score[i - 1] + dp[i - 3], dp[i - 2]) + score[i];
        }

        System.out.println(dp[n]);
    }
}
