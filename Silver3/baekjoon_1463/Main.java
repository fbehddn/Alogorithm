package Silver3.baekjoon_1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new Integer[n+1];
        // basecase
        dp[0] = dp[1] = 0;

        System.out.println(recursion(n));

    }

    private static int recursion(int n) {
        if (dp[n] == null) {
            if (n % 6 == 0) {
                dp[n] = Math.min(recursion(n - 1), Math.min(recursion(n / 3), recursion(n / 2))) + 1;
            } else if (n % 2 == 0) {
                dp[n] = Math.min(recursion(n / 2), recursion(n - 1)) + 1;
            } else if (n % 3 == 0) {
                dp[n] = Math.min(recursion(n / 3), recursion(n - 1)) + 1;
            } else {
                dp[n] = recursion(n - 1) + 1;
            }
        }
        return dp[n];
    }
}

/**
 * 1 -> 0번
 * 2 -> 2/2 = 1 -> 1번
 * 3 -> 3/3 = 1 -> 1번
 * 4 -> (4-1)/3 = 1 -> 2번, 4/2 , 2/2 -> 2번
 * 11 -> (11-1)/2 = 5 , (5-1)/2 = 2 , 2/2 = 1 -> 5번
 * 11 -> 11-1, 10-1, 9/3 =3, 3/3= 1 -> 4번
 * 12 -> 12/3 = 4, 4/2 = 2 , 2/2 = 1 -> 3번
 */
