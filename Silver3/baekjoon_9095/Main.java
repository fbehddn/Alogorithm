package Silver3.baekjoon_9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Integer[] dp = new Integer[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(recursive(n));
        }
    }

    private static Integer recursive(int n) {
        if (dp[n] == null) {
            dp[n] = recursive(n - 1) + recursive(n - 2) + recursive(n - 3);
        }

        return dp[n];
    }
}

/**
 * 1 -> 1
 * 2 -> 1+1, 2 // 2
 * 3 -> 1+1+1, 1+2, 2+1, 3 // 4
 * 4 -> 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 3+1,1+3,4 // 7
 * 5 -> 1+1+1+1+1, 1+1+1+2, 1+1+2+1, 1+2+1+1, 2+1+1+1, 1+2+2, 2+1+2, 2+2+1, 3+1+1, 1+3+1, 1+1+3,  3+2, 2+3 // 13
 * 6 -> 1+1+1+1+1+1, 1+1+1+1+2, 1+1+1+2+1, 1+1+2+1+1, 1+2+1+1+1, 2+1+1+1+1, 1+1+1+3, 1+1+3+1, 1+3+1+1, 3+1+1+1, 1+1+2+2, 1+2+1+2, 2+1+1+2, 2+2+1+1, 2+1+2+1, 1+2+2+1
 * 1+2+3, 1+3+2, 2+1+3, 2+3+1, 3+2+1, 3+1+2, 2+2+2, 3+3 //24
 * <p>
 * 1 2 4 7 13 24 44
 */
