package Silver3.baekjoon_1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer[][] dp = new Integer[41][2]; //각각의 정수에 대해 개수 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); //입력할 정수의 총 개수

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            fibo(N);
            sb.append(dp[N][0] + " " + dp[N][1]).append('\n');
        }
        System.out.println(sb);
    }

    private static Integer[] fibo(int num) {
        if (dp[num][0] == null || dp[num][1] == null) {
            dp[num][0] = fibo(num-1)[0] + fibo(num-2)[0];
            dp[num][1] = fibo(num-1)[1] + fibo(num-2)[1];
        }

        return dp[num];
    }
}

/**
 * dp = {{1,0}, {0,1}, {1,2}}
 */
