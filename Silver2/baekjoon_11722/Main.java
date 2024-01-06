package Silver2.baekjoon_11722;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] dp = new int[N];

        /**
         * 10 30 10 20 20 10
         * dp[0] =  1
         * dp[1] = 1
         * dp[2] = 2
         * dp[3] = 2
         * dp[4] = 2
         * dp[5] = 3
         */

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = 0;
        for (int i : dp) {
            max = i > max ? i : max;
        }
        System.out.println(max);
    }
}
