package Gold2.baekjoon_12015;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        /**
         * 시간 제한 때문에 bottom - up 이중 for 문 말고
         * top-down 재귀 사용해야 할 듯
         */
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            dp[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j + 1];
                }
            }
        }

        int result = 0;
        for (int i : dp) {
            result = i > result ? i : result;
        }
    }
}
