package Silver2.baekjoon_11053;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] seq = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            seq[i] = sc.nextInt();
        }

        // 10 20 10 30 20 50
        // dp[0] = 1, dp[1] = 2, dp[2] = 1, dp[3] = 3, dp[4] = 2, dp[5] = 4
        // why dp[2] = 1 ? =>

        /**
         * dp[3] = dp[2] + 1 = 2 가 아닌
         * dp[3] = dp[1] + 1 = 3 이여야한다.
         * 즉, seq 값이 자기보다 작은 값에 해당하는 dp의 값에 +1 을 해야함.
         */
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (seq[i] > seq[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = 0;
        for (int i : dp) {
            if(i>max) max = i;
        }
        System.out.println(max);
    }
}
